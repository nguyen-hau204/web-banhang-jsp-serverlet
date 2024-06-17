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
@Table(name = "ctsp")
@Entity
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "id_sp")
    @ManyToOne
    private SanPham sanPham;
    @JoinColumn(name = "id_mau_sac")
    @ManyToOne
    private mausacc mauSac;
    @JoinColumn(name = "id_size")
    @ManyToOne
    private Sizes sizes;
    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;


    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "id=" + id +
                ", sanPham=" + sanPham +
                ", mauSac=" + mauSac +
                ", sizes=" + sizes +
                ", giaBan=" + giaBan +
                ", soLuongTon=" + soLuongTon +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
