use ViGo
go

--table đơn đặt tour
CREATE TABLE DonDatTour (
  maDon NCHAR(50) primary key,
  maTour NCHAR(50) references Tour(maTour),
  maKH NCHAR(50) references KhachHang(maKH),
  gioGianDat DATE,
  soVe INT,
  tongTien money
);

--table hành khách
create table HanhKhach(
	maHK nchar(50) primary key,
	hoTen nvarchar(50),
	sdt nvarchar(15),
	maDon nchar(50) references DonDatTour(maDon)
)

--table khách hàng
create table KhachHang (
	maKH nchar(50),
	hoTen nvarchar(50),
	ngaySinh datetime,
	soDienThoai nvarchar(15),
	gioiTinh bit,
	email nvarchar(50),
	matKhau nvarchar(50),
	primary key (maKH)
)
alter table khachhang
delete Khachhang where maKH = 'NHH020303'

alter table KhachHang
add email nvarchar(50), matKhau nvarchar(50)
--insert
insert into KhachHang values('NHH020303',N'Nguyễn Hoàng Huy','2003-03-02','0362026128',1,N'ng.hoang.huy23@gmail.com',N'123')
--query
select * 
from KhachHang 


--table tour
create table Tour(
	maTour nchar(50) primary key,
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
	maHDV nchar(50) references HuongDanVien(maHDV)
)
--insert values
INSERT INTO Tour values ('HCM-DL230323', N'Vườn Quốc Gia Đà Lạt','2023-03-23 17:05:00', 3, 10, 4000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'16:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'NHH6128')
go
--query
select * 
from Tour t join HuongDanVien hdv
on t.maHDV = hdv.maHDV

  
--table hướng dẫn viên
create table HuongDanVien(
	maHDV nchar(50) primary key,
	tenHDV nvarchar(50),
	sdt nvarchar(15)
)
--insert values
insert into HuongDanVien values('NHH6128',N'Nguyễn Hoàng Huy','0362026128')

--query
select * from HuongDanVien



