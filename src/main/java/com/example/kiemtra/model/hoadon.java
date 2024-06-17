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
@Table(name = "hoa_don")
@Entity
public class hoadon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @Column(name = " trang_thai")
    private String trangThai;
    @Column(name = " ngay_sua ")
    private Date ngaySua;
    @Column(name = " ngay_tao")
    private Date ngayTao;
       @Column(name = "dia_chi")
    private String diaChi;
       @Column(name = " so_dien_thoai")
    private String sdt;

    @Override
    public String toString() {
        return "hoadon{" +
                "id=" + id +
                ", khachHang=" + khachHang +
                ", trangThai='" + trangThai + '\'' +
                ", ngaySua=" + ngaySua +
                ", ngayTao=" + ngayTao +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
