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
@Entity
@Table(name = "size")

public class Sizes {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "ma_size")
        private String  maSize;
        @Column(name = "ten_size")
        private String tenSize;
        @Column(name = "trang_thai")
        private String trangThai;
        @Column(name = "ngay_sua")
        private Date ngaySua;
        @Column(name = "ngay_tao")
        private Date ngayTao;

        @Override
        public String toString() {
            return "size{" +
                    "id=" + id +
                    ", maSize='" + maSize + '\'' +
                    ", tenSize='" + tenSize + '\'' +
                    ", trangThai='" + trangThai + '\'' +
                    ", ngaySua=" + ngaySua +
                    ", ngayTao='" + ngayTao + '\'' +
                    '}';
        }
    }


