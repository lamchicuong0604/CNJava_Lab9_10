# Project Spring Ecommerce
* Là một ứng dụng đơn giản về CRUD, sử dụng Spring Boot, Spring Security, RestFul API, MySQL, Thymeleaf.
## Các chức năng đã có
* Đăng ký với quyền mặc định là USER, đăng nhập.
* Admin có thể thêm sửa xóa sản phẩm.
* User có thể thêm sản phẩm vào giỏ hàng, xóa sản phẩm trong giỏ hàng.
* Trong giỏ hàng hiện tên sản phẩm, giá tiền từng sản phẩm.
## Các chức năng chưa hoàn thiện
* Giao diện đơn giản.
* Thanh toán.
* Xem chi tiết sản phẩm.
* Xem tổng tiền của tất cả sản phẩm trong giỏ hàng.
## Sơ đồ ERD của database
![ERD](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/erdiagram.png?raw=true)
#### **User** có mối quan hệ 1-n với **Cart**. Hay nói cách khác, một người dùng có thể thêm nhiều mặt hàng vào giỏ , nhưng mỗi giỏ hàng chỉ có thể có liên kết với người dùng đó.
#### **Cart** có mối quan hệ n-1 với **Product**. Hay nói cách khác, mỗi giỏ hàng sẽ liên kết với một sản phẩm, nhưng mỗi sản phẩm có thể có trong nhiều giỏ hàng khác nhau.
#### **Product** có mối quan hệ n-1 với **Category**. Hay nói cách khác, mỗi sản phẩm sẽ liên kết với một danh mục sản phẩm, nhưng mỗi danh mục sản phẩm có thể có nhiều sản phẩm khác nhau.
## Các nguyên tắc, công nghệ, cấu trúc được áp dụng trong project
### Công nghệ sử dụng 
* Ngôn ngữ sử dụng: Java, JavaScript.
* Framework: Springboot, Spring Data JPA, Spring Security,...
* View: HTML, CSS, JS.
* CSDL: MySQL.
### Nguyên tắc lập trình hướng đối tượng (OOP)
* Nguyên tắc này được áp dụng trong **Package model** để có thể tái sử dụng và dễ dàng chỉnh sửa các đối tượng sau này.
* Các Class sử dụng nguyên tắc này có các thuộc tính và hành vi cho phép chúng có thể tương tác với nhau và tương tác với các thành phần khác của project.
### Dependency Injection
* Được sử dụng để quản lý việc sử dụng method của những Class khác cũng như giúp viết Unit test dễ dàng hơn.
### Mô hình Repository
* Mục đích chính của mô hình Repository là cung cấp một interface làm trung gian để thao tác với dữ liệu, giúp cho việc truy xuất dữ liệu và thao tác với dữ liệu trở nên dễ dàng và linh hoạt hơn.
### Kiến trúc MVC
* Được sử dụng để phân chia rõ ràng giữa các thành phần của project như Model(Dữ liệu), View (Giao diện), Controller(Logic).
* **Model** chịu trách nhiệm xử lý dữ liệu và các thao tác liên quan đến dữ liệu như lưu trữ, truy vấn và cập nhật.
* **View** chịu trách nhiệm hiển thị dữ liệu và tương tác với người dùng thông qua giao diện.
* **Controller** chịu trách nhiệm xử lý các yêu cầu từ người dùng và điều khiển hoạt động của model và view, xử lý logic của ứng dụng.
## Cấu trúc code
* Project sẽ bao gồm folder:  **spring-commerce** cùng với các file ảnh ERD, API và file README.
### Front-end
* Gồm 2 folder **static** và **templates** trong đường dẫn **src/main/resources**
#### Folder **static** gồm các file sau: **account.js**, **product.js**, **style.css**. <br />

Trong đó
* **account.js**: dùng để xử lý các hoạt động liên quan đến tài khoản người dùng, bao gồm đăng nhập, đăng ký và đăng xuất.
* **product.js**: dùng để quản lý các hoạt động liên quan đến sản phẩm, bao gồm tìm kiếm, hiển thị, thêm và xoá khỏi giỏ hàng.
* **style.css**: chứa các định dạng cho trang web, bao gồm các giao diện, định dạng font chữ, màu sắc và các yếu tố khác của trang web.

#### Folder **templates** gồm các file sau: **login.html**, **productadmin.html**, **regis.html**. <br />
Trong đó
* **login.html**: chứa trang đăng nhập dành cho người dùng.
* **productadmin.html**: chứa trang hiển thị danh sách sản phẩm cũng như các nút, khung cho chức năng tìm kiếm, các pop-up window khi thêm, xoá, sửa sản phẩm.
* **regis.html**: chứa trang đăng ký tài khoản cho người dùng.
### Back-end
* **Controller layer**: Tầng này chứa các class để xử lý request từ UI đến hệ thống.
* **Model layer**: Tầng này chứa các class model của hệ thống, bao gồm các entities và dto.
* **Service layer**: Tầng này là tầng trung gian chứa các class trung gian xử lý logic giữa UI và DB.
* **DTO layer**: Tầng này có mục đích truyền dữ liệu giữa các class khác nhau, như trong project sẽ là truyền các tham số để tìm kiếm sản phẩm từ client đến server.
* **Repository layer**: Chịu trách nhiệm giao tiếp với các DB, xử lý query và trả về các kiểu dữ liệu mà tầng Service yêu cầu.
## Cài đặt project
### Hướng dẫn chạy project
* Clone source code về và chạy lại file pom để tải các dependency
* Cấu hình database trong file properties.yaml với các thông số của máy local
* Chạy câu lệnh **ALTER TABLE cart ADD UNIQUE INDEX duplli (product_id, user_id);** để tạo Unique index cho bảng cart, khi thêm sản phẩm vào giỏ hàng sẽ không bị lặp.
* Project sẽ chạy trên đường dẫn: **[http://localhost:8080/login](http://localhost:8080/login)**
* Ngoài test api bằng postman, ta có thể test tất cả API trên swagger-ui với đường dẫn: **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**
## Các API
### API read product
![read-product](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/read-product.png?raw=true)
### API search product
![search-product](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/search-product.png?raw=true)
### API create product
![create-product](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/create-product.png?raw=true)
### API update product
![update-product](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/update-product.png?raw=true)
### API read order in cart
![show-order-cart](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/show-order-cart.png?raw=true)
### API add product to cart
![add-product](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/add-product-to-cart.png?raw=true)
### API delete product from cart
![delete-product-order](https://github.com/hellfive123/Midterm_51900783_LamChiCuong/blob/master/delete-product.png?raw=true)
