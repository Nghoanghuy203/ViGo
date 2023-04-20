USE [QLTOUR]
GO

/****** Object:  Table [dbo].[Tour]    Script Date: 17/04/2023 9:00:44 CH ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Tour](
	[maTour] [nchar](15) NOT NULL,
	[tenTour] [nvarchar](50) NULL,
	[tgKhoiHanh] [datetime] NULL,
	[soNgay] [int] NULL,
	[soVeConLai] [int] NULL,
	[gia] [money] NULL,
	[hinhAnh] [varbinary](max) NULL,
	[tgTapTrung] [datetime] NULL,
	[diemDi] [nvarchar](50) NULL,
	[diemDen] [nvarchar](50) NULL,
	[tgCapNhat] [datetime] NULL,
 CONSTRAINT [PK_Tour] PRIMARY KEY CLUSTERED 
(
	[maTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO




INSERT INTO Tour 
values ('HCM-DL230323', N'Đà Lạt','2023-03-23 17:05:00', 3, 10, 5000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'2023-03-23 16:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
go

select * from Tour order by tgCapNhat desc

INSERT INTO Tour 
values ('HCM-DN230503', N'Bà NÀ Hill','2023-05-03 12:30:00', 4, 14, 7000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-05-03 11:30:00',N'TP.Hồ Chí Minh',N'Đà Nẵng',getdate(),'123132')
INSERT INTO Tour 
values ('HN-TN230423', N'Núi Bà Đen','2023-04-23 07:30:00', 2, 9, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-04-23 6:30:00',N'Hà Nội',N'Tây Ninh',getdate(),'123132')
INSERT INTO Tour 
values ('HN-PT230511', N'Phan Thiết','2023-05-11 08:00:00', 5, 10, 5500000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'2023-05-11 7:00:00',N'Hà Nội',N'Phan Thiết',getdate(),'123132')
INSERT INTO Tour 
values ('HCM-VT230511', N'Vũng Tàu','2023-05-11 14:30:00', 6, 14, 9000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-05-11 12:00:00',N'TP.Hồ Chí Minh',N'Vũng Tàu',getdate(),'123132')
INSERT INTO Tour 
values ('HCM-DL230418', N'Thung lũng love','2023-03-23 8:30:00', 2, 8, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-03-23 6:30:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')

INSERT INTO Tour 
values ('BT230503', N'Bến tre','2023-05-03 8:30:00', 2, 11, 4000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-05-03 7:30:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
INSERT INTO Tour 
values ('PT230423', N'Phan Thiết','2023-04-23 09:30:00', 4, 9, 4500000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-04-23 8:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
INSERT INTO Tour 
values ('CB230727', N'Cao Bằng','2023-01-01 08:00:00', 5, 10, 5500000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'2023-01-01 6:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
INSERT INTO Tour 
values ('SP230511', N'Sa Pa','2023-05-11 14:30:00', 6, 14, 9000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-05-11 14:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
INSERT INTO Tour 
values ('CM230418', N'Cà Mau','2023-04-18 8:30:00', 2, 8, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-04-18 7:00:00',N'TP.Hồ Chí Minh',N'Đà Lạt',getdate(),'123132')
INSERT INTO Tour 
values ('HA230503', N'Hội An','2023-05-03 12:30:00', 4, 14, 7000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-05-03 12:00:00',N'TP.Hồ Chí Minh',N'Hà Nội',getdate(),'123132')
INSERT INTO Tour 
values ('H230423', N'Huế','2023-04-23 07:30:00', 2, 9, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-04-18 6:00:00',N'TP.Hồ Chí Minh',N'Hà Nội',getdate(),'123133')
INSERT INTO Tour 
values ('VHL230727', N'Vịnh Hạ Long','2023-07-23 08:00:00', 5, 10, 5500000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img),'2023-07-23 7:00:00',N'TP.Hồ Chí Minh',N'Hà Nội',getdate(),'123133')
INSERT INTO Tour 
values ('KG230511', N'Kiên Giang','2023-04-18 14:30:00', 6, 14, 9000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img),'2023-04-18 14:00:00',N'TP.Hồ Chí Minh',N'Hà Nội',getdate(),'123133')
INSERT INTO Tour 
values ('KT230418', N'Kom Tum','2023-04-18 8:30:00', 2, 8, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img),'2023-04-18 8:00:00',N'TP.Hồ Chí Minh',N'Hà Nội',getdate(),'123133')

alter table tour
add tgTapTrung datetime null, noiKhoiHanh nvarchar(50) null, tgCapNhat datetime null

delete from tour

drop table Tour

select * from Tour where diemDi = N'TP.Hồ Chí Minh' and diemDen =N'Hà Nội' and convert(date,tgKhoiHanh) = '2023-04-18'

alter table tour 
add maHDV nvarchar(15) not null

insert into HuongDanVien
values ('123132',N'Lương Quốc Thái','093424243')

insert into HuongDanVien
values ('123133',N'Nguyễn Hoàng Huy','093343424')

delete from huongdanvien
select * from huongdanvien

drop table huongdanvien

CREATE TABLE [dbo].[Tour](
	[maTour] [nchar](15) NOT NULL,
	[tenTour] [nvarchar](50) NULL,
	[tgKhoiHanh] [datetime] NULL,
	[soNgay] [int] NULL,
	[soVeConLai] [int] NULL,
	[gia] [money] NULL,
	[hinhAnh] [varbinary](max) NULL,
	[tgTapTrung] [datetime] NULL,
	[diemDi] [nvarchar](50) NULL,
	[diemDen] [nvarchar](50) NULL,
	[tgCapNhat] [datetime] NULL,
	[maHDV] [nvarchar](15) NOT NULL
 CONSTRAINT [PK_Tour] PRIMARY KEY CLUSTERED 
(
	[maTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE tour
ADD CONSTRAINT fk_tour_id_hdv
 FOREIGN KEY (maHDV)
 REFERENCES huongdanvien (maHDV);

ALTER TABLE [huongdanvien] 
ALTER COLUMN [maHDV] [nvarchar](15)

select * 
from tour t join  HuongDanVien h
on t.maHDV=h.maHDV
where maTour='HCM-DN230503'