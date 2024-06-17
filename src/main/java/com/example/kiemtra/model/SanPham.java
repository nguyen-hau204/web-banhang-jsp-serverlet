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
@Table(name = "san_pham")
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = " ten_san_pham")

    private String tenSanPham;
    @Column(name = "ma_san_pham")
    private String maSanPham;
    @Column(name = " trang_thai")
    private String trangThai;
    @Column(name = " ngay_sua ")
    private Date ngaySua;
    @Column(name = " ngay_tao")
    private Date ngayTao;

    @ManyToOne  // quan hệ của bảng
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;




}
