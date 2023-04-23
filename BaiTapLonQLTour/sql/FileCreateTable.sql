use ViGo
go


--table đơn đặt tour
CREATE TABLE DonDatTour (
  maDon NVARCHAR(50) primary key,
  maTour NVARCHAR(50) references Tour(maTour),
  maKH NVARCHAR(50) references KhachHang(maKH),
  gioGianDat DATE,
  soVe INT,
  tongTien money
);


insert into DonDatTour values(N'Test',N'HCM-DL-VQGĐL230323',N'NHH0203031',getdate(),3,10000000)

select* from DonDatTour
--table hành khách
create table HanhKhach(
	maHK nvarchar(50) primary key,
	hoTen nvarchar(50),
	sdt nvarchar(15),
	maDon nvarchar(50) references DonDatTour(maDon)
)
insert into hanhkhach values(N'HHHH',N'Hoàng Huy',N'0232342424',N'Test')
--table khách hàng
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
alter table khachhang
delete Khachhang where maKH = 'NHH020303'

alter table KhachHang
add email nvarchar(50), matKhau nvarchar(50)
--insert
insert into KhachHang values(N'NHH0203031',N'Nguyễn Hoàng Huy','2003-03-02',N'0362026128',1,N'ng.hoang.huy23@gmail.com',N'123')
--query
select * 
from KhachHang 


--table tour
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
--insert values
INSERT INTO Tour values (N'HCM-DL-VQGĐL230323', N'Vườn Quốc Gia Đà Lạt','2023-03-23 17:05:00', 3, 10, 4000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'16:00:00',N'Hồ Chí Minh',N'Đà Lạt',getdate(),N'NHH220423')
go
--query
select * 
from Tour t join HuongDanVien hdv
on t.maHDV = hdv.maHDV

  
--table hướng dẫn viên
create table HuongDanVien(
	maHDV nvarchar(50) primary key,
	tenHDV nvarchar(50),
	sdt nvarchar(15)
)
--insert values
insert into HuongDanVien values(N'NHH220423',N'Nguyễn Hoàng Huy',N'0362026128')
insert into HuongDanVien values(N'NVA220423',N'Nguyễn Văn A',N'0362045328')
--query
select * from HuongDanVien



select *
from KhachHang
where exists (select * from khachhang where email=N'ng.hoang.huy23@gmail.com' and matKhau=N'1234')