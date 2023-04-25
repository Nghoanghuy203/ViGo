use master
go

/****** Object:  Database [ViGo]    Script Date: 24/04/2023 6:39:26 CH ******/
create database Nhom4_QLTour
on primary 
( NAME = N'Nhom4_QLTour', FILENAME = N'T:\Nhom4_QLTour.mdf' , SIZE = 7168KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
log on
( NAME = N'Nhom4_QLTour_log', FILENAME = N'T:\Nhom4_QLTour_log.ldf' , SIZE = 8384KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
go

use Nhom4_QLTour
go

--tạo bảng hướng dẫn viên
create table HuongDanVien(
	maHDV nvarchar(50) primary key,
	tenHDV nvarchar(50),
	sdt nvarchar(15)
)

--taọ bảng Tour
create table Tour(
	maTour nvarchar(50) primary key,
	tenTour nvarchar(50),
	tgKhoiHanh DateTime,
	soNgay int,
	soVeConLai int,
	gia money,
	hinhAnh varbinary(max),
	tgTapTrung time,
	diemDi nvarchar(50),
	diemDen nvarchar(50),
	tgCapNhat datetime,
	maHDV nvarchar(50) references HuongDanVien(maHDV)
)

--tạo bảng khách hàng
create table KhachHang (
	maKH nvarchar(50),
	hoTen nvarchar(50),
	ngaySinh datetime,
	soDienThoai nvarchar(15),
	gioiTinh bit,
	email nvarchar(50),
	matKhau nvarchar(50),
	primary key (maKH)
)


--tạo bảng đơn đặt tour
CREATE TABLE DonDatTour (
  maDon NVARCHAR(50) primary key,
  maTour NVARCHAR(50) references Tour(maTour),
  maKH NVARCHAR(50) references KhachHang(maKH),
  gioGianDat DATE,
  soVe INT,
  tongTien money
)

select*from hanhkhach

--tạo bảng hành khách
create table HanhKhach(
	maHK nvarchar(50) primary key,
	hoTen nvarchar(50),
	sdt nvarchar(15),
	maDon nvarchar(50) references DonDatTour(maDon)
)


--chèn dữ liệu mặc định cho database
--chèn hướng dẫn viên tour
insert into HuongDanVien values(N'LTM220423',N'Lê Thị Mèo',N'0362026128')
go
insert into HuongDanVien values(N'TVC220423',N'Trần Văn C',N'0362045328')
go
insert into HuongDanVien values(N'NVA220423',N'Nguyễn Văn A',N'0972342331')
go
insert into HuongDanVien values(N'PTM220323',N'Phan Thị Mơ',N'0936723573')
go

--chèn tour

INSERT INTO Tour values (N'HCM-LĐ-VQGĐL230323', N'Vườn Quốc Gia Đà Lạt','2023-03-23 17:05:00', 3, 10, 4000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\vuonhoadalat.png', SINGLE_BLOB) as img),'16:00:00',N'Hồ Chí Minh',N'Lâm Đồng',getdate(),N'TVC220423')
go
INSERT INTO Tour values (N'HCM-NB-CP010523', N'Vườn Quốc Gia Cúc Phương','2023-05-01 16:05:00', 5, 10, 5000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\cucphuong.jpg', SINGLE_BLOB) as img),'15:00:00',N'Hồ Chí Minh',N'Ninh Bình',getdate(),N'LTM220423')
go
INSERT INTO Tour values (N'HCM-LĐ-TDBR110523', N'Thác Dambri','2023-05-11 14:05:00', 2, 7, 2000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\thacdamri.jpg', SINGLE_BLOB) as img),'13:00:00',N'Hồ Chí Minh',N'Lâm Đồng',getdate(),N'TVC220423')
go
INSERT INTO Tour values (N'HCM-ĐN-AP010523', N'Asian Park','2023-05-01 11:05:00', 5, 15, 10000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\asianpark.jpg', SINGLE_BLOB) as img),'10:00:00',N'Hồ Chí Minh',N'Đà Nẵng',getdate(),N'PTM220323')
go
INSERT INTO Tour values (N'HCM-BĐ-QN170623', N'Quy Nhơn','2023-06-17 10:05:00', 3, 19, 6000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\quynhon.jpg', SINGLE_BLOB) as img),'09:00:00',N'Hồ Chí Minh',N'Bình Định',getdate(),N'NVA220423')
go
INSERT INTO Tour values (N'HCM-ĐN-BMK010523', N'Biển Mỹ Khê','2023-05-01 15:05:00', 5, 6, 7000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\bienmykhe.png', SINGLE_BLOB) as img),'14:00:00',N'Hồ Chí Minh',N'Đà Nẵng',getdate(),N'TVC220423')
go
INSERT INTO Tour values (N'HN-LĐ-BL300423', N'Bảo Lộc','2023-04-30 14:05:00', 5, 9, 10000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\baoloc.jpg', SINGLE_BLOB) as img),'13:00:00',N'Hà Nội',N'Lâm Đồng',getdate(),N'TVC220423')
go
INSERT INTO Tour values (N'HN-BĐ-EG170623', N'Eo Gió','2023-06-17 11:05:00', 4, 15, 8000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\eogio.jpg', SINGLE_BLOB) as img),'10:00:00',N'Hà Nội',N'Bình Định',getdate(),N'NVA220423')
go
INSERT INTO Tour values (N'HN-ĐN-BMK280523', N'Biển Mỹ Khê','2023-05-28 17:05:00', 3, 21, 8000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\bienmykhe.png', SINGLE_BLOB) as img),'16:00:00',N'Hà Nội',N'Đà Nẵng',getdate(),N'LTM220423')
go
INSERT INTO Tour values (N'HCM-NB-TA110623', N'Tràng An','2023-06-11 18:05:00', 3, 4, 5000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\trangan.jpg', SINGLE_BLOB) as img),'17:00:00',N'Hồ Chí Minh',N'Ninh Bình',getdate(),N'PTM220323')
go
INSERT INTO Tour values (N'HCM-PT-MN170623', N'Mũi Né','2023-06-17 15:05:00', 4, 24, 8000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\muine.jpg', SINGLE_BLOB) as img),'14:00:00',N'Hồ Chí Minh',N'Phan Thiết',getdate(),N'TVC220423')
go
INSERT INTO Tour values (N'HCM-LĐ-LBA0280523', N'Núi Langbiang','2023-05-28 16:05:00', 2, 7, 5000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\langbiang.jpg', SINGLE_BLOB) as img),'15:00:00',N'Hồ Chí Minh',N'Lâm Đồng',getdate(),N'NVA220423')
go
INSERT INTO Tour values (N'HN-BĐ-CLX010523', N'Cù Lao Xanh','2023-05-01 15:05:00', 5, 14, 10000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\culaoxanh.png', SINGLE_BLOB) as img),'14:00:00',N'Hà Nội',N'Bình Định',getdate(),N'LTM220423')
go
INSERT INTO Tour values (N'HCM-BĐ-EG010523', N'Eo Gió','2023-05-01 14:05:00', 4, 25, 7000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\eogio.jpg', SINGLE_BLOB) as img),'13:00:00',N'Hồ Chí Minh',N'Bình Định',getdate(),N'NVA220423')
go

--chèn khách hàng
insert into KhachHang values(N'KH0101011',N'Khách Hàng','2001-01-01',N'0362026128',1,N'khachhang@gmail.com',N'12345678')
go

