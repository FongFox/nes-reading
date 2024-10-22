package com.nesreading.controller;

import java.util.List;

import com.nesreading.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nesreading.domain.Author;
import com.nesreading.domain.Book;
import com.nesreading.domain.BookCategory;
import com.nesreading.domain.User;
import com.nesreading.service.AuthorService;
import com.nesreading.service.BookCategoryService;
import com.nesreading.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final AuthorService authorService;
    private final BookCategoryService bookCategoryService;
    private final BookService bookService;

    public AdminController(UserService userService, AuthorService authorService, BookCategoryService bookCategoryService, BookService bookService) {
        this.userService = userService;
        this.authorService = authorService;
        this.bookCategoryService = bookCategoryService;
        this.bookService = bookService;
    }

    // =============================== (Start) Dashboard Controller =====================================
    @GetMapping("")
    public String getDashboardPage() {
        return "admin/dashboard/view";
    }
    // =============================== (End) Dashboard Controller =======================================

    // =============================== (Start) User Controller =====================================
    @GetMapping("/users")
    public String getUserViewPage(Model model) {
        List<User> userList = this.userService.handleFetchAllUser();

        model.addAttribute("userList", userList);
    
        return "admin/user/view";
    }

    @GetMapping("/users/create")
    public String getUserCreatePage(Model model) {
        model.addAttribute("newUser", new User());

        return "admin/user/create";
    }

    @PostMapping("/users/create")
    public String handleCreateUser(@ModelAttribute("newUser") User user) {
        this.userService.handleCreateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}")
    public String getUserDetailPage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);

        model.addAttribute("user", user);

        return "admin/user/detail";
    }

    @GetMapping("/users/update/{id}")
    public String getUserUpdatePage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);
        if(user == null) {
            return "redirect:/admin/users";
        }
        model.addAttribute("tempUser", user);
        return "admin/user/update";
    }

    @PostMapping("/users/update")
    public String handleUpdateUser(@ModelAttribute("tempUser") User user) {
        userService.handleUpdateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String getUserDeletePage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);
        if(user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("tempUser", user);

        return "admin/user/delete";
    }

    @PostMapping("/users/delete")
    public String handleUserDeletePage(@ModelAttribute("tempUser") User user) {
        userService.handleDeleteUser(user.getId());
        return "redirect:/admin/users";
    }
    // =============================== (End) User Controller =======================================

    // =============================== (Start) Author Controller =====================================
    @GetMapping("/authors")
    public String getAuthorViewPage(Model model) {
        List<Author> authorList = authorService.handleFetchAllAuthors();

        model.addAttribute("authorList", authorList);

        return "admin/author/view";
    }

    @GetMapping("/authors/create")
    public String getAuthorCreatePage(Model model) {
        model.addAttribute("newAuthor", new Author());
        return "admin/author/create";
    }

    @PostMapping("/authors/create")
    public String handleCreateAuthor(@ModelAttribute("tempAuthor") Author author) {
        // System.out.println(author.toString());
        authorService.handleCreateUser(author);
        return "redirect:/admin/authors";
    }

    @GetMapping("/authors/update/{id}")
    public String getAuthorUpdatePage(@PathVariable long id ,Model model) {
        Author author = authorService.handleFetchAuthorById(id).orElse(null);
        if(author == null) {
            return "redirect:/admin/authors";
        }
        model.addAttribute("tempAuthor", author);
        return "admin/author/update";
    }

    @PostMapping("/authors/update")
    public String handleUpdateAuthor(@ModelAttribute("tempAuthor") Author author) {
        authorService.handleUpdateAuthor(author);
        return "redirect:/admin/authors";
    }

    @GetMapping("/authors/delete/{id}")
    public String getAuthorDeletePage(@PathVariable long id ,Model model) {
        Author author = authorService.handleFetchAuthorById(id).get();
        if(author == null) {
            return "redirect:/admin/authors";
        }
        model.addAttribute("tempAuthor", author);
        return "admin/author/delete";
    }

    @PostMapping("/authors/delete")
    public String handleDeleteAuthor(@ModelAttribute("tempAuthor") Author author) {
        authorService.handleDeleteAuthor(author.getId());
        return "redirect:/admin/authors";
    }
    // =============================== (End) Author Controller =======================================

    // =============================== (Start) Book Controller =====================================
    @GetMapping("/books")
    public String getBookViewPage(Model model) {
        return "admin/book/view";
    }

    @GetMapping("/books/create")
    public String getBookCreatePage(Model model) {
        List<Author> authorListAvailable = authorService.handleFetchAllAuthors();
        List<BookCategory> bookCategoryList = null;
        // List<BookCategory> bookCategoryList

        model.addAttribute("authorList", authorListAvailable);
        model.addAttribute("bookCategoryList", bookCategoryList);
        model.addAttribute("newBook", new Book());

        return "admin/book/create";
    }

    @PostMapping("/books/create")
    public String handleCreateBook(Model model, @ModelAttribute("newBook") Book book) {
        bookService.handleSaveBook(book);

        return "redirect:/admin/books";
    }

    @GetMapping("/books/{id}")
    public String getBookDetailPage(Model model) {
        return "admin/book/detail";
    }

    @GetMapping("/books/update/{id}")
    public String getBookUpdatePage(Model model) {
        return "admin/book/update";
    }

    @PostMapping("/books/update/{id}")
    public String handleUpdateBook(Model model) {
        return "redirect:/admin/books";
    }

    @GetMapping("/books/delete/{id}")
    public String getBookDeletePage(Model model) {
        return "admin/book/delete";
    }

    @PostMapping("/books/delete/{id}")
    public String handleDeleteBook(Model model) {
        return "redirect:/admin/books";
    }
    // =============================== (End) Book Controller ========================================

    // =============================== (Start) Category List Controller =====================================
    
    @GetMapping("/categories")
    public String getCategoryViewPage(Model model) {
        List<BookCategory> bookCategoryList = bookCategoryService.handleFetchAllBookCategories();

        model.addAttribute("bookCategoryList", bookCategoryList);

        return "admin/category/view";
    }
    
    @GetMapping("/categories/create")
    public String getCategoryCreatePage(Model model) {
        model.addAttribute("newBookCategory", new BookCategory());
        return "admin/category/create";
    }

    @PostMapping("/categories/create")
    public String handleCreateCategory(@ModelAttribute("tempCategory") BookCategory bookCategory) {
        // System.out.println(category.toString());
        bookCategoryService.handleCreateBookCategory(bookCategory);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/update/{id}")
    public String getBookCategoryUpdatePage(@PathVariable long id ,Model model) {
        BookCategory bookCategory = bookCategoryService.handleFetchBookCategoryById(id).orElse(null);
        if(bookCategory == null) {
            return "redirect:/admin/categories";
        }
        model.addAttribute("tempBookCategory", bookCategory);
        return "admin/category/update";
    }

    @PostMapping("/categories/update")
    public String handleUpdateBookCategory(@ModelAttribute("tempBookCategory") BookCategory bookCategory) {
        bookCategoryService.handleUpdateBookCategory(bookCategory);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String getBookCategoryDeletePage(@PathVariable long id ,Model model) {
        BookCategory bookCategory = bookCategoryService.handleFetchBookCategoryById(id).get();
        if(bookCategory == null) {
            return "redirect:/admin/categories";
        }
        model.addAttribute("tempBookCategory", bookCategory);
        return "admin/category/delete";
    }

        @PostMapping("/categories/delete")
        public String handleDeleteBookCategory(@ModelAttribute("tempBookCategory") BookCategory bookCategory) {
            bookCategoryService.handleDeleteBookCategory(bookCategory.getId());
        return "redirect:/admin/categories";
    
    }
    // =============================== (End) Category List Controller =====================================

    // =============================== (Start) Order Controller =====================================
    @GetMapping("/orders")
    public String getOderViewPage() {
        return "admin/order/view";
    }

    @GetMapping("/orders/create")
    public String getOderCreatePage() {
        return "admin/order/create";
    }

    @GetMapping("/orders/{id}")
    public String getOderDetailPage() {
        return "admin/order/detail";
    }

    @GetMapping("/orders/update/{id}")
    public String getOderUpdatePage() {
        return "admin/order/update";
    }

    @GetMapping("/orders/delete/{id}")
    public String getOderDeletePage() {
        return "admin/order/delete";
    }
    // =============================== (End) Order Controller =======================================
}
