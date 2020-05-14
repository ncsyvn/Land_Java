USE [master]
GO
/****** Object:  Database [Land]    Script Date: 5/14/2020 2:39:23 PM ******/
CREATE DATABASE [Land]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Land', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Land.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Land_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Land_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Land] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Land].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Land] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Land] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Land] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Land] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Land] SET ARITHABORT OFF 
GO
ALTER DATABASE [Land] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Land] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Land] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Land] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Land] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Land] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Land] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Land] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Land] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Land] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Land] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Land] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Land] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Land] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Land] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Land] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Land] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Land] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Land] SET  MULTI_USER 
GO
ALTER DATABASE [Land] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Land] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Land] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Land] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Land] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Land]
GO
/****** Object:  Table [dbo].[Company]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CompanyName] [nvarchar](250) NOT NULL,
	[CompanyAddress] [nvarchar](250) NULL,
	[CompanyImage] [nvarchar](250) NULL,
	[CompanyMail] [nvarchar](250) NULL,
	[CompanyHotline] [nvarchar](250) NULL,
	[CompanyFacebook] [nvarchar](250) NULL,
	[CompanyYoutube] [nvarchar](250) NULL,
	[CompanyGoogle] [nvarchar](250) NULL,
	[CompanyTwitter] [nvarchar](250) NULL,
	[CompanyInfor] [nvarchar](250) NULL,
	[CreateDtime] [datetime] NOT NULL,
	[UpdateDtime] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NewCategories]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NewCategories](
	[NewCategoryId] [int] IDENTITY(1,1) NOT NULL,
	[NewCategoryName] [nvarchar](250) NULL,
	[OrderNo] [int] NULL,
	[IsActive] [bit] NULL,
	[CreateDtime] [datetime] NULL,
	[UpdateDtime] [datetime] NULL,
	[Id] [nvarchar](128) NULL,
 CONSTRAINT [PK__NewCateg__84E7EAB340806051] PRIMARY KEY CLUSTERED 
(
	[NewCategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[News]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[NewId] [int] IDENTITY(1,1) NOT NULL,
	[NewCategoryId] [int] NOT NULL,
	[NewName] [nvarchar](250) NULL,
	[NewSortName] [nvarchar](250) NULL,
	[NewImage] [nvarchar](250) NULL,
	[NewDescription] [nvarchar](max) NULL,
	[NewBody] [nvarchar](max) NULL,
	[Count] [int] NULL,
	[Enable] [bit] NULL,
	[IsHotNew] [bit] NULL,
	[CreateDtime] [datetime] NULL,
	[NewTag] [nvarchar](250) NULL,
	[Id] [nvarchar](128) NULL,
 CONSTRAINT [PK__News__7CC3777ED9094CDE] PRIMARY KEY CLUSTERED 
(
	[NewId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductCategories]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCategories](
	[ProductCategoryId] [nvarchar](250) NOT NULL,
	[ProductCategoryTitle] [nvarchar](max) NULL,
	[ProductCategoryName] [nvarchar](250) NULL,
	[OrderNo] [int] NULL,
	[IsActive] [bit] NULL,
	[CreateDtime] [datetime] NULL,
	[UpdateDtime] [datetime] NULL,
	[CreateBy] [nvarchar](250) NULL,
	[ParentProductCategoryId] [nvarchar](250) NULL,
	[ProductCategoryDescription] [nvarchar](max) NULL,
	[ProductCategoryKeyword] [nvarchar](250) NULL,
	[ProductCategoryImage] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductCategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Products]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductId] [int] IDENTITY(1,1) NOT NULL,
	[ProductCategoryId] [nvarchar](250) NOT NULL,
	[ProductName] [nvarchar](250) NULL,
	[ProductSummary] [nvarchar](max) NULL,
	[ProductImage] [nvarchar](max) NULL,
	[ProductThumbnail] [nvarchar](max) NULL,
	[ProductPrice] [float] NULL,
	[ProductArea] [float] NULL,
	[ProductBedrooms] [int] NULL,
	[ProductBathrooms] [int] NULL,
	[ProductAddress] [nvarchar](250) NULL,
	[UpdateBy] [nvarchar](250) NULL,
	[OrderNo] [int] NULL,
	[IsActive] [bit] NULL,
	[IsHotProduct] [bit] NULL,
	[ProductReviewHtml] [nvarchar](max) NULL,
	[ProductPriceMeter] [float] NULL,
	[ProductFloors] [int] NULL,
	[ProductTag] [nvarchar](max) NULL,
	[CreateDtime] [datetime] NULL,
	[UpdateDtime] [datetime] NULL,
	[ProjectId] [nvarchar](max) NULL,
 CONSTRAINT [PK__Products__B40CC6CD8075DA9C] PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[role]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role](
	[r_id] [int] IDENTITY(1,1) NOT NULL,
	[r_name] [varchar](50) NULL,
	[r_description] [nvarchar](max) NULL,
	[r_status] [bit] NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Slide]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slide](
	[SlideId] [int] IDENTITY(1,1) NOT NULL,
	[SlideImage] [nvarchar](max) NOT NULL,
	[IsActive] [bit] NULL,
	[OrderNo] [int] NULL,
	[UpdateBy] [nvarchar](50) NULL,
	[UpdateDtime] [datetime] NULL,
	[URLSlide] [nvarchar](max) NULL,
	[CreateDTime] [datetime] NULL,
	[Id] [nvarchar](128) NULL,
PRIMARY KEY CLUSTERED 
(
	[SlideId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](max) NULL,
	[password] [nvarchar](max) NULL,
	[u_email] [nvarchar](150) NULL,
	[u_status] [bit] NULL,
	[u_fullname] [nvarchar](250) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user_role]    Script Date: 5/14/2020 2:39:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role](
	[ur_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[role_id] [int] NULL,
 CONSTRAINT [PK_user_role] PRIMARY KEY CLUSTERED 
(
	[ur_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[NewCategories] ON 

INSERT [dbo].[NewCategories] ([NewCategoryId], [NewCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [Id]) VALUES (6, N'Tin Bán', 1, 1, NULL, CAST(N'2020-04-21 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[NewCategories] ([NewCategoryId], [NewCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [Id]) VALUES (7, N'Tin Thuê', 1, 1, CAST(N'2020-04-21 00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[NewCategories] ([NewCategoryId], [NewCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [Id]) VALUES (8, N'test', 1, 1, CAST(N'2020-04-21 00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[NewCategories] ([NewCategoryId], [NewCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [Id]) VALUES (9, N'Tin Khác', 3, 1, CAST(N'2020-04-27 00:00:00.000' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[NewCategories] OFF
SET IDENTITY_INSERT [dbo].[News] ON 

INSERT [dbo].[News] ([NewId], [NewCategoryId], [NewName], [NewSortName], [NewImage], [NewDescription], [NewBody], [Count], [Enable], [IsHotNew], [CreateDtime], [NewTag], [Id]) VALUES (6, 9, N'Covid19', NULL, N'/Uploads/ddn6627-1587971481108461405594.jpg', N'Sản xuất thành công sinh phẩm mới, Việt Nam đã có thể xét nghiệm Covid-19 từ tuyến huyện', N'<h2>Sản xuất thành công sinh phẩm mới, Việt Nam đã có thể xét nghiệm Covid-19 từ tuyến huyện</h2><p>&nbsp;</p><h2>Là nước thứ 5 trên thế giới sản xuất thành công sinh phẩm xét nghiệm kháng thể (xét nghiệm nhanh Covid-19), Bộ Y tế đánh giá sinh phẩm xét nghiệm nhanh "made in Vietnam" có nhiều ưu điểm, đặc biệt giúp các cơ sở y tế tuyến huyện có thể xét nghiệm phát hiện virus SARS-CoV-2.</h2><ul><li><a href="https://kenh14.vn/bac-ninh-kiem-tra-may-xet-nghiem-covid-19-gia-59-ty-bac-giang-dung-mua-de-kiem-tra-gia-20200427115842022.chn">Bắc Ninh kiểm tra máy xét nghiệm COVID-19 giá 5,9 tỷ, Bắc Giang dừng mua để kiểm tra giá</a></li><li><a href="https://kenh14.vn/so-y-te-thai-nguyen-khong-mua-may-moi-chi-cai-tien-may-cu-de-xet-nghiem-sars-cov-2-2020042712122474.chn">Sở Y tế Thái Nguyên: "Không mua máy mới, chỉ cái tiến máy cũ để xét nghiệm SARS-CoV-2"</a></li><li><a href="https://kenh14.vn/994-mau-xet-nghiem-lien-quan-den-benh-nhan-268-deu-am-tinh-voi-virus-gay-covid-19-20200427100654975.chn">994 mẫu xét nghiệm liên quan đến bệnh nhân 268 đều âm tính với virus gây COVID-19</a></li></ul><p>Trong cuộc họp phòng chống dịch Covid-19 sáng 27/4,&nbsp;Ban Chỉ đạo Quốc gia đã bàn về công tác xét nghiệm phát hiện virus SARS-CoV-2 để phục vụ phòng, chống dịch bệnh trong thời gian tới.<br>&nbsp;</p><p>Hiện, trên thế giới đang triển khai song song 2 phương pháp xét nghiệm xác định người dương tính Covid-19 là xét nghiệm tìm gen virus (phương pháp PCR) và xét nghiệm kháng thể (thường sử dụng để xét nghiệm nhanh).</p><p><strong>Phương pháp PCR</strong> có độ chính xác cao vì phát hiện trực tiếp gen của virus, nên tại thời điểm dương tính thì bệnh nhân chắc chắn đang có virus SARS-CoV-2 trong người. Tuy nhiên, phương pháp này đòi hỏi các khâu chuyên môn hóa cao, cần có chuyên gia thực hiện với nhiều máy móc phức tạp, thời gian cho kết quả lâu (vài giờ).</p><p>Trong khi đó, <strong>phương pháp xét nghiệm nhanh</strong> tìm kháng thể có thời gian ngắn, vận hành đơn giản, người làm xét nghiệm không cần thiết phải được đào tạo chuyên biệt, không cần thiết bị đặc biệt kèm theo. Tuy nhiên, phương pháp này có độ nhạy, độ đặc hiệu thấp hơn nhiều so với phương pháp PCR, dễ nhầm và bỏ sót.</p><p><strong>Vì vậy, phương pháp PCR thường được dùng để khẳng định lại kết quả xét nghiệm nhanh.</strong></p><figure class="image"><img src="https://kenh14cdn.com/thumb_w/620/2020/4/27/ddn6627-1587971481108461405594.jpg" alt="Sản xuất thành công sinh phẩm mới, Việt Nam đã có thể xét nghiệm Covid-19 từ tuyến huyện - Ảnh 1."></figure><p><i>Toàn cảnh buổi họp Ban chỉ đạo phòng, chống Covid-19 sáng 27/4. Ảnh: VGP/Đình Nam</i></p><p>&nbsp;</p><p>Trong công tác phòng, chống dịch bệnh, phối hợp cả 2 phương pháp xét nghiệm sẽ giúp kiểm soát dịch bệnh nhanh, giảm tải áp lực y tế và tập trung nguồn lực vào điều trị những ca thực sự mắc SARS-CoV-2</p><p><strong>Về phương pháp xét nghiệm PCR</strong>, Thứ trưởng Thường trực Bộ Y tế Nguyễn Thanh Long cho biết, thời gian đầu chúng ta sử dụng nguồn sinh phẩm từ nước ngoài (từ Tổ chức Y tế thế giới (WHO), CDC Hoa Kỳ, Đức).&nbsp;</p><p>Sau đó, Việt Nam đã phát triển được loại sinh phẩm xét nghiệm PCR rất tốt do Học viện Quân y phối hợp với công ty Việt Á phát triển, thay thế nguồn nước ngoài. Sinh phẩm này đã và đang được sử dụng chủ đạo tại Việt Nam để xét nghiệm phát hiện virus SARS-CoV-2.</p><p>Tới nay, chúng ta đã xét nghiệm được khoảng 212.000 mẫu bệnh phẩm, phát hiện 270 trường hợp mắc Covid-19, tỷ lệ phát hiện dương tính khoảng 0,13%, là một trong những quốc gia có tỷ lệ phát hiện dương tính trên tổng số mẫu xét nghiệm cao nhất thế giới.</p><p>&nbsp;</p><p>Hiện cả nước có 112 phòng xét nghiệm Realtime - PCR có năng lực xét nghiệm phát hiện SARS-CoV-2 (công suất tối đa khoảng hơn 27.000 mẫu/ngày), trong đó 48 phòng đã được phép xét nghiệm khẳng định Covid-19 (công suất tối đa khoảng 14.300 mẫu/ngày).</p><p>Bên cạnh đó, Bộ Y tế đã cho rà soát lại toàn bộ hệ thống máy móc xét nghiệm bằng phương pháp PCR sẵn có tại doanh nghiệp để huy động, không cần trang bị thêm.</p><p>Bộ sinh phẩm xét nghiệm bằng phương pháp PCR của Việt Nam đã được WHO, Vương quốc Anh công nhận chất lượng và có thể được sử dụng trên phạm vi toàn cầu.</p><figure class="image"><img src="https://kenh14cdn.com/thumb_w/620/2020/4/27/ddn6602-15879714811015078429.jpg" alt="Sản xuất thành công sinh phẩm mới, Việt Nam đã có thể xét nghiệm Covid-19 từ tuyến huyện - Ảnh 2."></figure><p><i>Phó Thủ tướng Vũ Đức Đam tại cuộc họp Ban Chỉ đạo quốc gia phòng chống dịch bệnh Covid-19. Ảnh: VGP/Đình Nam</i></p><p>&nbsp;</p><p><strong>Về phương pháp xét nghiệm kháng thể (xét nghiệm nhanh)</strong>, theo lãnh đạo Bộ Y tế, vừa qua, ở Việt Nam mới chỉ có thành phố Hà Nội triển khai phương pháp này, sử dụng sinh phẩm của Hàn Quốc, do doanh nghiệp tài trợ. Thành phố đã xét nghiệm tổng số 18.450 mẫu, phát hiện 50 trường hợp dương tính nhưng sau khi thực hiện xét nghiệm lại bằng phương pháp PCR cả 50 trường hợp đều cho kết quả âm tính.</p><p>Lãnh đạo Bộ Y tế cho biết, thời gian qua, Viện Vệ sinh dịch tễ Trung ương đã phối hợp với một trường đại học của Nhật Bản để nghiên cứu và phát triển thành công loại sinh phẩm xét nghiệm kháng thể có độ nhạy, độ đặc hiệu cao hơn nhiều so với các loại sinh phẩm tương tự mà nhiều nước đang sử dụng.</p><p>Điểm khác biệt rất đáng chú ý là sinh phẩm xét nghiệm nhanh của Việt Nam sử dụng hệ thống máy xét nghiệm ELISA đã được trang bị từ tuyến Trung ương đến tận y tế tuyến huyện để chẩn đoán người nhiễm HIV, sốt xuất huyết và một số bệnh miễn dịch khác.</p>', 0, 0, 1, CAST(N'2020-04-27 00:00:00.000' AS DateTime), N'covid19', NULL)
INSERT [dbo].[News] ([NewId], [NewCategoryId], [NewName], [NewSortName], [NewImage], [NewDescription], [NewBody], [Count], [Enable], [IsHotNew], [CreateDtime], [NewTag], [Id]) VALUES (7, 9, N'Ga ngầm Metro đầu tiên được hoàn thành ở Sài Gòn: Ngỡ như “thiên đường” dưới lòng đất, thiết kế theo kiến trúc của Nhà hát Thành phố', NULL, N'/Uploads/img7469-15879038063971487790876.jpg_320752', N'Toàn bộ các hoạ tiết, màu sắc tường, ánh sáng,… trong nhà ga ngầm đầu tiên vừa hoàn thành trên tuyến Metro Bến Thành – Suối Tiên được thiết kế theo lối kiến trúc của Nhà hát Thành phố. Đây là điểm nhấn đặc biệt của các nhà ga ngầm, mỗi nhà ga sẽ mang một kiến trúc riêng theo từng địa danh.', N'<h2>Ga ngầm Metro đầu tiên được hoàn thành ở Sài Gòn: Ngỡ như “thiên đường” dưới lòng đất, thiết kế theo kiến trúc của Nhà hát Thành phố</h2><p>TỨ QUÝ, CLIP: KINGPRO, THEO <a href="http://ttvn.toquoc.vn/">TRÍ THỨC TRẺ</a> 00:00 27/04/2020</p><p><a href="javascript:;">Chia sẻ285</a></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><h2>Toàn bộ các hoạ tiết, màu sắc tường, ánh sáng,… trong nhà ga ngầm đầu tiên vừa hoàn thành trên tuyến Metro Bến Thành – Suối Tiên được thiết kế theo lối kiến trúc của Nhà hát Thành phố. Đây là điểm nhấn đặc biệt của các nhà ga ngầm, mỗi nhà ga sẽ mang một kiến trúc riêng theo từng địa danh.</h2><ul><li><a href="https://kenh14.vn/can-canh-nhung-hinh-anh-ben-trong-ga-ngam-nha-hat-thanh-pho-cua-tuyen-metro-ben-thanh-suoi-tien-20200424193636962.chn">Cận cảnh những hình ảnh bên trong ga ngầm Nhà hát Thành phố của tuyến Metro Bến Thành - Suối Tiên</a></li><li><a href="https://kenh14.vn/ngam-doan-tau-toc-do-110km-h-dau-tien-cua-tuyen-metro-ben-thanh-suoi-tien-chuan-bi-ve-sai-gon-20200413110308236.chn">Ngắm đoàn tàu tốc độ 110km/h đầu tiên của tuyến Metro Bến Thành - Suối Tiên chuẩn bị về Sài Gòn</a></li><li><a href="https://kenh14.vn/metro-ben-thanh-suoi-tien-chinh-thuc-duoc-thong-tuyen-chuyen-sang-giai-doan-lap-rap-20200217164920324.chn">Metro Bến Thành - Suối Tiên chính thức được thông tuyến, chuyển sang giai đoạn lắp ráp</a></li></ul><p>Mới đây, tầng B1 ga Nhà hát Thành phố (quận 1) thuộc dự án tuyến đường sắt đô thị Bến Thành – Suối Tiên (Metro số 1) cơ bản đã hoàn thiện. Đây là hạng mục đầu tiên của dự án nhà ga ngầm thuộc tuyến Metro được hoàn thành và hoàn thành trước tiến độ gần 100 ngày so với kế hoạch ban đầu của nhà thầu.&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>Và đặc biệt hơn khi một phần của nhà ga ngầm Metro được hoàn thiện trước dịp lễ 30/4/2020, mang dấu ấn to lớn trong việc phát triển đô thị của TP. HCM. Để có được những thành quả hơn mong đợi ấy, toàn bộ công nhân, kỹ sư, thiết kế,… của Việt Nam và Nhật Bản đã nỗ lực thi công xuyên mùa dịch Covid-19, để có thể đón người dân vào tham quan trong dịp lễ 30/4 tới đây.&nbsp;</p><figure class="image"><img src="https://kenh14cdn.com/thumb_w/1000/2020/4/26/img7469-15879038063971487790876.jpg" alt="Ga ngầm Metro đầu tiên được hoàn thành ở Sài Gòn: Ngỡ như “thiên đường” dưới lòng đất, thiết kế theo kiến trúc của Nhà hát Thành phố - Ảnh 2."></figure><p><i>Phía trên mặt đất của ga ngầm Nhà hát TP được cải tạo thành vườn hoa.</i></p><p>&nbsp;</p><p>Có cơ hội bước vào bên trong nhà ga ngầm Nhà hát Thành phố, điều đầu tiên ập vào mắt chúng tôi là sự choáng ngợp.&nbsp;</p><p>Một kỹ sư trong Ban quản lý đường sắt đô thị cũng giới thiệu về công trình đặc biệt này đó là toàn bộ kiến trúc bên trong nhà ga ngầm này đều theo kiểu kiến trúc của Nhà hát Thành phố đang hiện hữu. Những gam màu trên tường, ánh sáng, hoạ tiết trang trí,… đều mang hơi hướng của nhà hát.&nbsp;</p><figure class="image"><img src="https://kenh14cdn.com/thumb_w/660/2020/4/26/img7628-15879038064431322693985.jpg" alt="Ga ngầm Metro đầu ti&amp;#234;n được ho&amp;#224;n th&amp;#224;nh ở S&amp;#224;i G&amp;#242;n: Ngỡ như “thi&amp;#234;n đường” dưới l&amp;#242;ng đất, thiết kế theo kiến tr&amp;#250;c của Nh&amp;#224; h&amp;#225;t Th&amp;#224;nh phố - Ảnh 3."></figure><figure class="image"><img src="https://kenh14cdn.com/thumb_w/660/2020/4/26/img7471-15879038063991724012221.jpg" alt="Ga ngầm Metro đầu ti&amp;#234;n được ho&amp;#224;n th&amp;#224;nh ở S&amp;#224;i G&amp;#242;n: Ngỡ như “thi&amp;#234;n đường” dưới l&amp;#242;ng đất, thiết kế theo kiến tr&amp;#250;c của Nh&amp;#224; h&amp;#225;t Th&amp;#224;nh phố - Ảnh 3."></figure><p>Có 5 vị trí có thể tiếp cận đi xuống nhà ga ngầm Nhà hát TP.</p><p>Anh kỹ sư này cũng chia sẻ thêm, tất cả 3 nhà ga ngầm của tuyến Metro số 1 cũng sẽ được thiết kế theo kiến trúc của từng địa danh, như ga Nhà hát TP thì kiến trúc theo Nhà hát TP, ga Bến Thành thì kiến trúc theo chợ Bến Thành, ga Ba Son cũng vậy.&nbsp;</p><p>Tất cả 3 nhà ga ngầm đều theo kiến trúc của từng địa danh để khi người dân đi tàu sẽ cảm nhận được mình đang ở nhà ga nào.&nbsp;</p><p>Ga ngầm Nhà hát TP hiện có 5 vị trí có thể tiếp cận đi xuống, gồm đoạn trước cửa Tổng Công ty Du lịch Sài Gòn, khu vực đường Lê Lợi, khu vực Sài Gòn Square và khách sạn Rex - tất cả đều là những vị trí xung quanh Nhà hát TP.</p><p>Không gian của nhà ga Nhà hát TP được thiết kế khá rộng từ khu vực bán vé, đi dạo tham quan, đi tàu,… với chiều dài 190m, rộng 26m.&nbsp;</p><figure class="image"><img src="https://kenh14cdn.com/thumb_w/660/2020/4/26/img7630-15879038064451990763285.jpg" alt="Ga ngầm Metro đầu ti&amp;#234;n được ho&amp;#224;n th&amp;#224;nh ở S&amp;#224;i G&amp;#242;n: Ngỡ như “thi&amp;#234;n đường” dưới l&amp;#242;ng đất, thiết kế theo kiến tr&amp;#250;c của Nh&amp;#224; h&amp;#225;t Th&amp;#224;nh phố - Ảnh 4."></figure><p>Cầu thang đi xuống tầng 1 nhà ga ngầm.</p><p>Toàn bộ ga ngầm gồm 4 tầng, riêng tầng B1 đã hoàn thiện cơ bản, 3 tầng còn lại đang xây dựng. Tầng 1 là nơi đặt các trang thiết bị phục vụ hành khách (sảnh đợi, máy bán vé, cổng thu phí tự động, nhà vệ sinh), phòng hướng dẫn thông tin cho hành khách.&nbsp;</p>', 0, 0, 1, CAST(N'2020-04-27 00:00:00.000' AS DateTime), N'Metro', NULL)
SET IDENTITY_INSERT [dbo].[News] OFF
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'32f857e4-fed6-41db-a688-95797a9efe81', N'Charmington Golf & Life là dự án tổ hợp căn hộ và biệt thự nằm trong khu compound khép kín.', N'Charmington Golf', 1, NULL, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, N'DUAN', N'Charmington Golf & Life là dự án tổ hợp căn hộ và biệt thự nằm trong khu compound khép kín, tọa lạc tại số 18B Nguyễn Văn Linh, thuộc xã Bình Hưng, huyện Bình Chánh, Thành phố Hồ Chí Minh.





Click vào để biết vị trí dự án

Bạn muốn đặt Hotline ở đây

TIN RAO THUỘC DỰ ÁN

Tin rao bán Căn hộ chung cư Charmington Golf & Life
Tin rao cho thuê Căn hộ chung cư Charmington Golf & Life

Quy mô dự án căn hộ Charmington Golf & Life



Tổ hợp căn hộ, biệt thự Charmington Golf & Life Bình Chánh



Charmington Golf & Life nằm trên khu đất có tổng diện tích 5,3 ha, với mật độ xây dựng 23%. Được chia làm 2 phân khu: khu thấp tầng nằm trên diện tích đất 5.500 m2 và khu cao tầng nằm trên diện tích đất 4.500 m2. Tổng diện tích sàn xây dựng là 22.854 m2. Diện tích đất dành cho công viên cây xanh và các tiện ích của dự án Charmington Golf & Life chiếm khoảng 4,3 ha.

Tổ hợp căn hộ, biệt thự Charmington Golf & Life Bình Chánh

Theo đó, phân khu thấp tầng của dự án có tổng cộng 10 căn biệt thự, với diện tích dao động từ 200 m2 - 500 m2. Phân khu cao tầng gồm 2 tòa tháp căn hộ cao 18 tầng với 1 tầng hầm, có tổng cộng 124 căn hộ, được thiết kế từ 1 - 3 phòng ngủ, với diện tích dao động từ 52 m2 - 95 m2.

Ngay bên dưới tòa nhà là khu thương mại 3 tầng được tích hợp với các tiện ích như: gym club, coffee house, beauty salon, nhà hàng, sigar bar…

Tổ hợp căn hộ, biệt thự Charmington Golf & Life Bình Chánh

Tổ hợp căn hộ, biệt thự Charmington Golf & Life Bình Chánh

Tổ hợp căn hộ, biệt thự Charmington Golf & Life Bình Chánh

Đây là khu compound khép kín kết hợp với tiện ích sân tập golf với diện tích 1,5 ha nằm ngay trong khuôn viên dự án. Ngoài ra, bên trong dự án còn có các tiện ích khác như: khu BBQ, sân tennis, bóng rổ, hồ bơi, khu sinh hoạt ngoài trời,...

Dự án cách nút giao Nguyễn Văn Linh - Quốc lộ 50 khoảng 400m và cách Đại lộ Võ Văn Kiệt khoảng 4km. Từ vị trí dự án Charmington Golf & Life di chuyển về trung tâm Quận 1 khoảng 8km.', N'Biet Thu', NULL)
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'47e0e39e-98b4-461a-bf22-61017d3d4f11', N'Sáng 26/5, Phú Đông Group chính thức ra mắt dự án Khu căn hộ Phú Đông Premier tọa lạc tại mặt tiền đường Lê Trọng Tấn liền kề đại lộ Phạm Văn Đồng.', N'Phú Đông Premier', 0, NULL, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, N'DUAN', N'<p><strong>Sáng 26/5, Phú Đông Group chính thức ra mắt dự án Khu căn hộ Phú Đông Premier tọa lạc tại mặt tiền đường Lê Trọng Tấn liền kề đại lộ Phạm Văn Đồng.</strong></p><p>&nbsp;</p><p>&nbsp;</p><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/thitruong/2018/05/tuan-04/khach-hang-xem-sa-ban-du-an-phu-dong-premier-1527419705.jpg&amp;t=1" alt="Ra mắt 657 căn hộ dự án Phú Đông Premier"></figure><p>&nbsp;</p><p>Phú Đông Premier là dự án thứ hai do Phú Đông Group phát triển hướng đến đối tượng khách hàng trẻ sau dự án Khu dân cư Him Lam Phú Đông.</p><p>Dự án Phú Đông Premier tọa lạc tại mặt tiền đường Lê Trọng Tấn liền kề đại lộ Phạm Văn Đồng (tuyến đường nội đô đẹp nhất Sài Gòn), dễ dàng kết nối với các quận nội thành như Q.1, Bình Thạnh và sân bay Tân Sơn Nhất.</p><p>Với diện tích đất 5.000m2, gồm 02 block nhà cao 35 tầng , tổng số 657 căn hộ có diện tích trung bình 66,5 m2/căn hộ hai phòng ngủ. Căn hộ Phú Đông Premier được bàn giao hoàn thiện nội thất cao cấp với những thương hiệu nổi tiếng: cửa gỗ với khoá từ, sàn gỗ cao cấp, thiết bị vệ sinh ToTo, thiết bị bếp TEKA và hệ thống smart home.</p><p>Khách hàng chỉ phải trả 20% giá trị căn hộ cho đến khi nhận nhà trong thời gian 2 năm; chủ đầu tư hỗ trợ 100% lãi suất đến khi nhận nhà, ân hạn nợ gốc 12 tháng, giá chỉ từ 1,35 tỷ đồng/căn hộ hai phòng ngủ&nbsp;(chưa bao gồm VAT).</p><p>Phú Đông Group cho biết, sau buổi lễ giới thiệu đã có 90% tổng số căn hộ đã được khách hàng tham dự đặt quyền mua thành công.</p><p>Dự án được khởi công vào tháng 12/2017. Dự kiến giao nhà vào tháng 6/2020.</p>', N'', N'/uploads/download_998243.jpg')
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'4d4ae68b-70f1-4a34-892f-bf79c0f85523', N'Flamingo Crown Bay là dự án tổ hợp nhà phố thương mại, khách sạn mini, căn hộ biệt thự trên cao, tọa lạc trên đầu mũi biển Linh Trường (chạy dọc 12km đường bờ biển)', N'Khu đô thị Flamingo Crown Bay', 0, NULL, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, N'DUAN', N'<p><strong>Flamingo Crown Bay là dự án tổ hợp nhà phố thương mại, khách sạn mini, căn hộ biệt thự trên cao, tọa lạc trên đầu mũi biển Linh Trường (chạy dọc 12km đường bờ biển) thuộc xã Hoằng Trường, huyện Hoằng Hóa, tỉnh Thanh Hóa.</strong></p><p>&nbsp;</p><p>&nbsp;</p><p><a href="https://nhadat.cafeland.vn/map/tin-du-an/19.888272243246/105.95929532917/2599/"><strong>Click vào để biết vị trí dự án</strong></a></p><p><a href="https://cafeland.vn/ho-tro/dat-hotline-vao-bai-gioi-thieu-du-an-174.html?duan_id=2599"><strong>Bạn muốn đặt Hotline ở đây</strong></a></p><h2><strong>TIN RAO THUỘC DỰ ÁN</strong></h2><ul><li>Tin rao <a href="https://nhadat.cafeland.vn/ban-du-an/flamingo-crown-bay-2599/"><strong>bán Khu dân cư Flamingo Crown Bay</strong></a></li><li>Tin rao <a href="https://nhadat.cafeland.vn/cho-thue-du-an/flamingo-crown-bay-2599/"><strong>cho thuê Khu dân cư Flamingo Crown Bay</strong></a></li></ul><h2><strong>Quy mô dự án khu đô thị Flamingo Crown Bay</strong></h2><p>&nbsp;</p><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/duan/2020/03/tuan-03/flamingo-crown-bay-1584828339.jpg?t=1" alt="Khu đô thị Flamingo Crown Bay Thanh Hóa"></figure><p>&nbsp;</p><p>Flamingo Crown Bay có tổng diện tích 19,18 ha với&nbsp;mật độ xây dựng khoảng 38%. Dự án khu đô thị Flamingo Crown Bay được chia làm 3 phân khu: Beryl,&nbsp;Aquamarine và Coral.&nbsp;</p><p>Bên trong dự án khu đô thị Flamingo Crown Bay được chia làm 3 dòng sản phẩm chính là:</p><figure class="table"><table><tbody><tr><td colspan="2"><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/duan/2020/03/tuan-03/khu-do-thi-flamingo-crown-bay-thanh-hoa-1584957627.jpg?t=1" alt="Khu đô thị Flamingo Crown Bay Thanh Hóa"></figure></td></tr><tr><td><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/duan/2020/03/tuan-03/flamingo-crown-bay-1584958597.jpg?t=1" alt="Khu đô thị Flamingo Crown Bay Thanh Hóa"></figure></td><td><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/duan/2020/03/tuan-03/flamingo-crown-bay-2-1584958616.jpg?t=1" alt="Khu đô thị Flamingo Crown Bay Thanh Hóa"></figure></td></tr></tbody></table></figure><p>Shophouse là tổ hợp nhà phố thương mại, cao 4 tầng, với tổng số 330 căn nhà phố thương mại, có diện tích dao động từ 91,5 m2 – 114 m2 (dùng để ở và kết hợp kinh doanh).</p><p>Mini Hotel là loại hình khách sạn nghỉ dưỡng, cao 7,5 tầng, với tổng số 40 căn khách sạn mặt biển, có diện tích dao động từ 291 m2 – 388 m2.</p><p>Forest In The Sky Villa: là dự án căn hộ biệt thự trên cao hướng biển, cao 21 tầng, có diện tích dao động từ 32 m2 – 70 m2.</p><p>Bên cạnh đó, còn có các tiện ích như: công viên 1,9 ha, dịch vụ bãi biển, bar, cafe, hệ thống bể bơi,...</p>', N'', N'/uploads/download (7)_464855.jpg')
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'70fd2c87-b591-4de8-9d61-1fa78fa3f15a', N'', N'fdsafs', 0, NULL, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, N'', N'', N'', NULL)
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'Ban', N'Bán', N'Ban', 0, 1, NULL, CAST(N'2019-12-24 21:21:55.567' AS DateTime), NULL, N'1', N'<p>11111</p>', N'1111', N'')
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'DUAN', N'Dự án', N'Duan', 0, 1, NULL, CAST(N'2019-12-12 23:50:29.693' AS DateTime), NULL, N'1', N'', N'/du-an', NULL)
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'e44f4733-1d5a-47a5-9448-7680fd24bc9e', N'Cuối tuần qua, chủ đầu tư dự án khu biệt thự Holm Residences đã giới thiệu những căn biệt thự ven sông cuối cùng của dự án này tại số 151, Nguyễn Văn Hưởng, phường Thảo Điền, quận 2, TP.HCM.', N'Dự án Holm Residences', 0, NULL, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, N'DUAN', N'<p><strong>Cuối tuần qua, chủ </strong><a href="https://cafeland.vn/danh-ba/dau-tu-du-an/4/"><strong>đầu tư dự án</strong></a><strong> khu biệt thự Holm Residences đã giới thiệu những căn biệt thự ven sông cuối cùng của dự án này tại số 151, Nguyễn Văn Hưởng, phường Thảo Điền, quận 2, TP.HCM.</strong></p><p>&nbsp;</p><p>&nbsp;</p><figure class="image"><img src="https://cafeland.vn/image-data/600-0/static1.cafeland.vn/cafelandData/upload/tintuc/thitruong/2017/04/tuan-01/du-an-holm-quan-2-1491233585.jpg&amp;t=1" alt="Ra mắt biệt thự ven sông tại dự án Holm Residences"></figure><p>&nbsp;</p><p>Dự án <a href="https://cafeland.vn/du-an/khu-biet-thu-holm-villas-thao-dien-1288.html"><strong>Holm Residences</strong></a> do Công ty Sapphire làm chủ đầu tư, được xây dựng trên một vùng đất rộng 2,7ha tại phường Thảo Điền, quận 2 với hơn 200m mặt sông Sài Gòn, cách trung tâm thành phố khoảng 5km.</p><p>Dự án bao gồm 29 căn biệt thự có diện tích khuôn viên từ 272 m2 – 1.018 m2, trong đó có 11 căn biệt thự ven sông, 6 căn biệt thự hồ bơi và 12 căn biệt thự sân vườn – tất cả đều có garage đỗ được từ 2 – 3 xe ô tô.</p><p>Theo chủ đầu tư, các căn biệt thự ven sông có 5 phòng ngủ, khu bếp khô và ướt riêng biệt,phòng khách thông tầng, 2 phòng nghỉ cho người giúp việc, garage đỗ được 3 xe hơi…</p><p>Các căn biệt thự ven sông sẽ được bàn giao vào tháng 5/2017 và có giá bán trung bình khoảng khoảng 100 tỷ/căn.</p><p>Ngoài ra, nội khu dự án Holm Residences còn bao gồm các tiện ích cao cấp như bể bơi nước mặn tràn bờ, trung tâm thể thao, công viên ven sông, phòng gym, hệ thống an ninh 24/7…</p>', N'', N'/uploads/download (6)_957294.jpg')
INSERT [dbo].[ProductCategories] ([ProductCategoryId], [ProductCategoryTitle], [ProductCategoryName], [OrderNo], [IsActive], [CreateDtime], [UpdateDtime], [CreateBy], [ParentProductCategoryId], [ProductCategoryDescription], [ProductCategoryKeyword], [ProductCategoryImage]) VALUES (N'THUE', N'Thuê ', N'Thue', 0, 1, NULL, CAST(N'2019-12-12 11:21:04.450' AS DateTime), NULL, N'1', N'', N'/thue-nha', NULL)
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductId], [ProductCategoryId], [ProductName], [ProductSummary], [ProductImage], [ProductThumbnail], [ProductPrice], [ProductArea], [ProductBedrooms], [ProductBathrooms], [ProductAddress], [UpdateBy], [OrderNo], [IsActive], [IsHotProduct], [ProductReviewHtml], [ProductPriceMeter], [ProductFloors], [ProductTag], [CreateDtime], [UpdateDtime], [ProjectId]) VALUES (0, N'DA001', N'123', N'123', N'/Uploads/download (1).jpg_424010*/Uploads/download (2).jpg_866885*/Uploads/download.jpg_350474*/Uploads/images.jpg_353927*', N'/Uploads/unnamed.jpg', 1233434, 123, 123, 123, N' 123', NULL, 123, 0, 1, NULL, 123, 123, NULL, NULL, CAST(N'2020-04-13 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[Products] ([ProductId], [ProductCategoryId], [ProductName], [ProductSummary], [ProductImage], [ProductThumbnail], [ProductPrice], [ProductArea], [ProductBedrooms], [ProductBathrooms], [ProductAddress], [UpdateBy], [OrderNo], [IsActive], [IsHotProduct], [ProductReviewHtml], [ProductPriceMeter], [ProductFloors], [ProductTag], [CreateDtime], [UpdateDtime], [ProjectId]) VALUES (13, N'DA001', N'new123', N'Test', NULL, N'/Uploads/unnamed.jpg', 123, 234, 0, 0, NULL, NULL, 0, 0, 0, NULL, 0, 0, NULL, NULL, CAST(N'2020-04-21 00:00:00.000' AS DateTime), NULL)
INSERT [dbo].[Products] ([ProductId], [ProductCategoryId], [ProductName], [ProductSummary], [ProductImage], [ProductThumbnail], [ProductPrice], [ProductArea], [ProductBedrooms], [ProductBathrooms], [ProductAddress], [UpdateBy], [OrderNo], [IsActive], [IsHotProduct], [ProductReviewHtml], [ProductPriceMeter], [ProductFloors], [ProductTag], [CreateDtime], [UpdateDtime], [ProjectId]) VALUES (14, N'DUAN', N'biet thu', N'', NULL, N'/Uploads/download (2).jpg', 1001, 0, 0, 0, N'Ha Noi', NULL, 0, 0, 1, NULL, 0, 0, NULL, CAST(N'2020-04-25 00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[Products] ([ProductId], [ProductCategoryId], [ProductName], [ProductSummary], [ProductImage], [ProductThumbnail], [ProductPrice], [ProductArea], [ProductBedrooms], [ProductBathrooms], [ProductAddress], [UpdateBy], [OrderNo], [IsActive], [IsHotProduct], [ProductReviewHtml], [ProductPriceMeter], [ProductFloors], [ProductTag], [CreateDtime], [UpdateDtime], [ProjectId]) VALUES (20, N'32f857e4-fed6-41db-a688-95797a9efe81', N'Nhà Thông Minh Futhouse', N'', NULL, N'/Uploads/download (5)_93657.jpg', 0, 0, 0, 0, N'fdc', NULL, 0, 0, 1, NULL, 0, 0, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[Products] ([ProductId], [ProductCategoryId], [ProductName], [ProductSummary], [ProductImage], [ProductThumbnail], [ProductPrice], [ProductArea], [ProductBedrooms], [ProductBathrooms], [ProductAddress], [UpdateBy], [OrderNo], [IsActive], [IsHotProduct], [ProductReviewHtml], [ProductPriceMeter], [ProductFloors], [ProductTag], [CreateDtime], [UpdateDtime], [ProjectId]) VALUES (21, N'DA001', N'VINCOM', N'Test', NULL, N'/Uploads/download (4)_299431.jpg', 12311111111, 234, 3, 4, N'Nguyễn Trãi', NULL, 1, 0, 1, NULL, 12, 3, NULL, CAST(N'2020-04-28 00:00:00.000' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[Products] OFF
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([r_id], [r_name], [r_description], [r_status]) VALUES (4, N'admin', N'quyền admin', 1)
INSERT [dbo].[role] ([r_id], [r_name], [r_description], [r_status]) VALUES (5, N'user', N'quyền user', 1)
SET IDENTITY_INSERT [dbo].[role] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [username], [password], [u_email], [u_status], [u_fullname]) VALUES (1, N'ducdv', N'$2a$10$3GPNgoC40YD7bfJCdK8dJuOHZXPsn5E.CKavNzYpi2muHHN4L4jyS', NULL, NULL, N'Dương Văn Đức')
INSERT [dbo].[user] ([id], [username], [password], [u_email], [u_status], [u_fullname]) VALUES (2, N'admin', N'$2a$10$GwPkCFzWv.ds2ktGqPX94.r46Jl.1LOUXrow02/6TIZVhK63f8gvq', NULL, NULL, N'admin')
INSERT [dbo].[user] ([id], [username], [password], [u_email], [u_status], [u_fullname]) VALUES (3, N'user', N'$2a$10$SiJZV1lfGCzdg7fL3ZuZSOmqnvMGbGkCCXORDQmcE6uZDlHVuwpeW', NULL, NULL, N'user')
SET IDENTITY_INSERT [dbo].[user] OFF
SET IDENTITY_INSERT [dbo].[user_role] ON 

INSERT [dbo].[user_role] ([ur_id], [user_id], [role_id]) VALUES (1, 1, 4)
INSERT [dbo].[user_role] ([ur_id], [user_id], [role_id]) VALUES (2, 2, 4)
INSERT [dbo].[user_role] ([ur_id], [user_id], [role_id]) VALUES (3, 3, 5)
SET IDENTITY_INSERT [dbo].[user_role] OFF
ALTER TABLE [dbo].[News]  WITH CHECK ADD  CONSTRAINT [FK__News__NewCategor__239E4DCF] FOREIGN KEY([NewCategoryId])
REFERENCES [dbo].[NewCategories] ([NewCategoryId])
GO
ALTER TABLE [dbo].[News] CHECK CONSTRAINT [FK__News__NewCategor__239E4DCF]
GO
USE [master]
GO
ALTER DATABASE [Land] SET  READ_WRITE 
GO
