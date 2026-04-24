-- Done toan bộ
--Tạo DB, file này khong duoc chay tự động mà chỉ được chạy thủ công
-- Đã tạo thủ công qua PHPMyadmin thay cho file này.
CREATE DATABASE IF NOT EXISTS petclinic;

ALTER DATABASE petclinic
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER IF NOT EXISTS 'petclinic'@'%' IDENTIFIED BY 'petclinic';

GRANT ALL PRIVILEGES ON petclinic.* TO 'petclinic'@'%';

FLUSH PRIVILEGES;
