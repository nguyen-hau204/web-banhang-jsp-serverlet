USE [master]
GO
/****** Object:  Database [java4]    Script Date: 6/11/2024 6:45:46 PM ******/
CREATE DATABASE [java4]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'java4', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\java4.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'java4_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\java4_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [java4] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [java4].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [java4] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [java4] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [java4] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [java4] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [java4] SET ARITHABORT OFF 
GO
ALTER DATABASE [java4] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [java4] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [java4] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [java4] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [java4] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [java4] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [java4] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [java4] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [java4] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [java4] SET  ENABLE_BROKER 
GO
ALTER DATABASE [java4] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [java4] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [java4] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [java4] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [java4] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [java4] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [java4] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [java4] SET RECOVERY FULL 
GO
ALTER DATABASE [java4] SET  MULTI_USER 
GO
ALTER DATABASE [java4] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [java4] SET DB_CHAINING OFF 
GO
ALTER DATABASE [java4] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [java4] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [java4] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [java4] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'java4', N'ON'
GO
ALTER DATABASE [java4] SET QUERY_STORE = ON
GO
ALTER DATABASE [java4] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [java4]
GO
/****** Object:  Table [dbo].[ctsp]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ctsp](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_sp] [int] NULL,
	[id_mau_sac] [int] NULL,
	[id_size] [int] NULL,
	[gia_ban] [decimal](18, 2) NULL,
	[so_luong_ton] [int] NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danh_muc]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danh_muc](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma_danh_muc] [varchar](255) NULL,
	[ten_danh_muc] [varchar](255) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hdct]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hdct](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_hoa_don] [int] NULL,
	[id_ctsp] [int] NULL,
	[so_luong_mua] [int] NULL,
	[gia_ban] [decimal](18, 2) NULL,
	[tong_tien] [decimal](18, 2) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_khach_hang] [int] NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
	[dia_chi] [nvarchar](255) NULL,
	[so_dien_thoai] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ho_ten] [nvarchar](255) NULL,
	[dia_chi] [nvarchar](255) NULL,
	[sdt] [varchar](20) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mau_sac]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mau_sac](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma_mau] [varchar](255) NULL,
	[ten_mau] [varchar](255) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_sua] [datetime] NULL,
	[ngay_tao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[san_pham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma_san_pham] [varchar](255) NULL,
	[ten_san_pham] [varchar](255) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_tao] [datetime] NULL,
	[ngay_sua] [datetime] NULL,
	[id_danh_muc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[size]    Script Date: 6/11/2024 6:45:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[size](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ma_size] [varchar](255) NULL,
	[ten_size] [varchar](255) NULL,
	[trang_thai] [varchar](50) NULL,
	[ngay_sua] [datetime] NULL,
	[ngay_tao] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ctsp]  WITH CHECK ADD  CONSTRAINT [fk_mau_sac] FOREIGN KEY([id_mau_sac])
REFERENCES [dbo].[mau_sac] ([id])
GO
ALTER TABLE [dbo].[ctsp] CHECK CONSTRAINT [fk_mau_sac]
GO
ALTER TABLE [dbo].[ctsp]  WITH CHECK ADD  CONSTRAINT [fk_size] FOREIGN KEY([id_size])
REFERENCES [dbo].[size] ([id])
GO
ALTER TABLE [dbo].[ctsp] CHECK CONSTRAINT [fk_size]
GO
ALTER TABLE [dbo].[ctsp]  WITH CHECK ADD  CONSTRAINT [fk_sp] FOREIGN KEY([id_sp])
REFERENCES [dbo].[san_pham] ([id])
GO
ALTER TABLE [dbo].[ctsp] CHECK CONSTRAINT [fk_sp]
GO
ALTER TABLE [dbo].[hdct]  WITH CHECK ADD  CONSTRAINT [fk_ctsp] FOREIGN KEY([id_ctsp])
REFERENCES [dbo].[ctsp] ([id])
GO
ALTER TABLE [dbo].[hdct] CHECK CONSTRAINT [fk_ctsp]
GO
ALTER TABLE [dbo].[hdct]  WITH CHECK ADD  CONSTRAINT [fk_hoa_don] FOREIGN KEY([id_hoa_don])
REFERENCES [dbo].[hoa_don] ([id])
GO
ALTER TABLE [dbo].[hdct] CHECK CONSTRAINT [fk_hoa_don]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [fk_khach_hang] FOREIGN KEY([id_khach_hang])
REFERENCES [dbo].[khach_hang] ([id])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [fk_khach_hang]
GO
ALTER TABLE [dbo].[san_pham]  WITH CHECK ADD  CONSTRAINT [fk_san_pham_danh_muc] FOREIGN KEY([id_danh_muc])
REFERENCES [dbo].[danh_muc] ([id])
GO
ALTER TABLE [dbo].[san_pham] CHECK CONSTRAINT [fk_san_pham_danh_muc]
GO
USE [master]
GO
ALTER DATABASE [java4] SET  READ_WRITE 
GO
