package com.example.hubtel


data class CardContent(
    val transactionDate:String,
    val serviceProvider:String,
    val recipient:String,
    val hasExtraRecipient:Boolean,
    val telephone:String,
    val transactionStatus:String,
    val transactionAmount:Int,
    val transactionPurpose:String,
    val hasTransactionReference:Boolean,
    val hasFavoriteIcon:Boolean
)
