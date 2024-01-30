package com.creve_ip.award.form;

import lombok.Data;


@Data
public class ThanksForm {

    private String senderVisibility; // 1．投稿者公表の可否 FIXME: Booleanにする？

    private String recipient; // 2．受賞者

    private String[] category; // 3．感謝のカテゴリー。各チェックボックスに対応するBoolean値が入ったリストを用意。FIXME: Booleanにする？

    private String episode; // 4．具体的なエピソード
}