# NesReadingAdmin (Admin Dashboard)

## I. Ghi Chú Thư Mục Chung

### 1. Ghi Chú Cấu Trúc Thư Mục (Tổng Quan)

- src:
  
  - main:
    
    - java:
      
      - com/admin/nesreading:
        
        - config (Cấu hình ứng dụng)
        
        - domain (Các class JPA Entity)
        
        - repository (Các interface JPA repository)
        
        - service { Các lớp service (chứa logic nghiệp vụ) }
        
        - web (controller):
          
          - rest (Controller cho API REST)
          
          - mvc  {Controller cho giao diện MVC (cho Thymeleaf)}
    
    - resources:
      
      - i18n (Các file đa ngôn ngữ)
      
      - templates (Thư mục chứa các file Thymeleaf):
        
        - layouts {Các layout dùng chung (ví dụ header, footer)}
        
        - pages {Các trang giao diện (ví dụ: home.html, user.html)}
      
      - static (Tài nguyên tĩnh như CSS, JS, hình ảnh)
  
  - test (Chứa các file test)



## II. Khác