package com.example.kiemtra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "danh_muc") // xác định bảng
@Entity // đámh dấu là một thực thể
public class DanhMuc {

    @Id // nhân định thuộc tính bên dưới là id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // map đén id tự tăng

    private Integer id;

    @Column(name = "ma_danh_muc")
    private String maDanhMuc;
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;

    @Column(name = "trang_thai")
    private String  trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "DanhMuc{" +
                "id=" + id +
                ", maDanhMuc='" + maDanhMuc + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
