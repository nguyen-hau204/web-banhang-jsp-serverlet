package com.example.kiemtra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "hdct")
@Entity
public class hdct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "id_hoa_don")
    @ManyToOne
    private hoadon hoadon;
    @JoinColumn(name = "id_ctsp")
    @ManyToOne
    private ChiTietSanPham chiTietSanPham;
    @Column(name = "so_luong_mua")
    private Integer soLuongMua ;
   @Column(name = "gia_ban")
    private Double giaBan ;
   @Column(name = "tong_tien")
    private Double tongTien ;
   @Column(name = "trang_thai")
    private String trangThai ;

    @Column(name = " ngay_sua ")
    private Date ngaySua;
    @Column(name = " ngay_tao")
    private Date ngayTao;

    @Override
    public String toString() {
        return "hdct{" +
                "id=" + id +
                ", hoadon=" + hoadon +
                ", chiTietSanPham=" + chiTietSanPham +
                ", soLuongMua=" + soLuongMua +
                ", giaBan=" + giaBan +
                ", tongTien=" + tongTien +
                ", trangThai=" + trangThai +
                ", ngaySua=" + ngaySua +
                ", ngayTao=" + ngayTao +
                '}';
    }
}
