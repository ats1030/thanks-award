package com.creve_ip.award.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class ThanksPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderVisibility; // 1．投稿者公表の可否 FIXME: Booleanにする？
    
    private String sender;

    private String recipient; // 2．受賞者

    private String categoryId; // 3．カテゴリーテーブルに対応する FIXME: intにする？

    private String episode; // 4．具体的なエピソード
}
