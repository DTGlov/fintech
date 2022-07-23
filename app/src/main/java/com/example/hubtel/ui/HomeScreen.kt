package com.example.hubtel.ui


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubtel.BottomMenuContent
import com.example.hubtel.CardContent
import com.example.hubtel.R
import com.example.hubtel.ui.theme.*


@Composable
fun HomeScreen(fontFamily: FontFamily) {
    val notificationDate1 = "May 24, 2022"
    val notificationDate2 = "May 23, 2022"
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(scaffoldState = scaffoldState,
             floatingActionButtonPosition = FabPosition.Center,
             floatingActionButton = {
                 FloatyBtn(
                     fontFamily, modifier = Modifier
                             .clip(RoundedCornerShape(20))
                 )
             },
             content = {
                 Column {
                     ToggleButtonSection(fontFamily)
                     Divider(
                         color = GreyColor, modifier = Modifier
                                 .padding(top = 20.dp)
                                 .fillMaxWidth(),
                         thickness = 3.dp
                     )
                     InputSection(fontFamily)
                     Column(
                         modifier = Modifier
                                 .verticalScroll(state = scrollState)
                                 .padding(bottom = 200.dp)
                     ) {
                         NotificationDate(fontFamily, notificationDate1)
                         CardSection(
                             fontFamily = fontFamily, items = listOf(
                                 CardContent(
                                     "14:45PM",
                                     "momo",
                                     "Emmanuel Rockson",
                                     true,
                                     "024 123 4567",
                                     "Successful",
                                     500,
                                     "Personal",
                                     hasTransactionReference = true,
                                     hasFavoriteIcon = true
                                 ),
                                 CardContent(
                                     "14:45PM",
                                     "absa",
                                     "Absa Bank",
                                     false,
                                     "024 123 4567",
                                     "Failed",
                                     500,
                                     "Personal",
                                     hasTransactionReference = true,
                                     hasFavoriteIcon = false
                                 )
                             )
                         )
                         NotificationDate(fontFamily, notificationDate2)
                         CardSection(
                             fontFamily = fontFamily, items = listOf(
                                 CardContent(
                                     "14:45PM",
                                     "momo",
                                     "Emmanuel Rockson",
                                     false,
                                     "024 123 4567",
                                     "Successful",
                                     500,
                                     "Other",
                                     hasTransactionReference = true,
                                     hasFavoriteIcon = true
                                 ),
                                 CardContent(
                                     "14:45PM",
                                     "momo",
                                     "Emmanuel Rockson",
                                     false,
                                     "024 123 4567",
                                     "Successful",
                                     500,
                                     "Other",
                                     hasTransactionReference = false,
                                     hasFavoriteIcon = false
                                 )
                             )
                         )
                     }

                 }
             },
             bottomBar = {
                 BottomMenu(
                     fontFamily,
                     items = listOf(
                         BottomMenuContent("Home", R.drawable.home_icon),
                         BottomMenuContent("Send", R.drawable.group_38555),
                         BottomMenuContent("History", R.drawable.group_38547__1_),
                         BottomMenuContent("Scheduled", R.drawable.schedule),
                     )
                 )
             }
    )
}

@Composable
fun ToggleButtonSection(fontFamily: FontFamily) {
    Box(modifier = Modifier.padding(top = 32.dp, start = 22.dp, end = 22.dp)) {
        Box(
            modifier = Modifier
                    .clip(RoundedCornerShape(30))
                    .background(GreyColor)
                    .padding(top = 5.dp, end = 5.dp, start = 5.dp, bottom = 5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = WhiteColor),
                    modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(35.dp),

                    ) {
                    Text(text = "History", fontFamily = fontFamily, fontWeight = FontWeight.Bold)
                }
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = GreyColor),
                    modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(35.dp),
                ) {
                    Text(text = "Transaction summary", color = GreyText, fontFamily = fontFamily)
                }
            }

        }
    }
}

@Composable
fun InputSection(fontFamily: FontFamily) {
    Box(modifier = Modifier.padding(start = 22.dp, end = 22.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                    .padding(top = 10.dp)
        ) {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            TextField(
                value = text,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color.Black
                    )
                },
                modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(0.9f)
                        .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = GreyColor,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                placeholder = {
                    Text(
                        text = "Search",
                        color = InputColor,
                        fontSize = 16.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Normal
                    )
                },
                onValueChange = {
                    text = it
                },
            )
            Image(
                painterResource(id = R.drawable.group_38142),
                contentDescription = "bars",
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
fun NotificationDate(fontFamily: FontFamily, notificationDate: String) {
    Box(
        modifier = Modifier
                .padding(top = 32.dp)
                .padding(start = 22.dp, end = 22.dp)
    ) {
        Box(
            modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(GreyColor)
                    .padding(10.dp)
        ) {
            Text(
                fontSize = 12.sp,
                text = notificationDate,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = GreyText
            )
        }

    }
}

@Composable
fun CardSection(
        fontFamily: FontFamily,
        items: List<CardContent>,
) {
    Column(modifier = Modifier.padding(start = 22.dp, end = 22.dp)) {
        items.forEach { item ->
            CardItem(fontFamily = fontFamily, item = item)
        }
    }
}

@Composable
fun CardItem(
        fontFamily: FontFamily,
        item: CardContent,
) {
    Card(
        Modifier
                .padding(top = 32.dp)
                .fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = item.transactionDate,
                        color = GreyText,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                    Row(modifier = Modifier.padding(top = 20.dp)) {
                        Image(
                            painterResource(id = if (item.serviceProvider == "momo") R.drawable.mtn_mobile_money else R.drawable.images),
                            contentDescription = item.serviceProvider,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                    .padding(end = 10.dp)
                                    .height(60.dp)
                                    .width(60.dp)
                        )
                        Column {
                            Text(
                                text = item.recipient,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                            if (item.hasExtraRecipient) {
                                Text(
                                    text = "Kwabena Uncle Ebo",
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = fontFamily,
                                    fontSize = 14.sp
                                )
                            }
                            Text(
                                modifier = Modifier.padding(top = 8.dp),
                                text = item.telephone,
                                color = GreyText,
                                fontFamily = fontFamily,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(start = 10.dp, top = 35.dp)
                ) {
                    Box(
                        modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(if (item.transactionStatus == "Successful") SuccessPillBg else FailedColorBg)
                                .padding(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painterResource(id = if (item.transactionStatus === "Successful") R.drawable.group_39150__1_ else R.drawable.group_39150),
                                contentDescription = item.transactionStatus,
                                contentScale = ContentScale.Crop, modifier = Modifier
                                        .height(15.dp)
                                        .width(15.dp)
                            )
                            Text(
                                text = item.transactionStatus,
                                color = if (item.transactionStatus == "Successful") SuccessColor else FailedColor,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                modifier = Modifier
                                        .padding(start = 5.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "GHS ${item.transactionAmount}",
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Right,
                        fontSize = 14.sp
                    )
                }

            }
            Divider(
                color = GreyColor,
                modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .padding(bottom = 10.dp, top = 10.dp)
                        .padding(10.dp)
                        .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.group_39560), modifier = Modifier
                                .height(35.dp)
                                .width(35.dp), contentDescription = "profile"
                    )
                    Text(
                        text = item.transactionPurpose,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp, end = 5.dp)
                    )
                    if (item.hasTransactionReference) {
                        Box(
                            modifier = Modifier
                                    .clip(CircleShape)
                                    .height(5.dp)
                                    .width(5.dp)
                                    .background(GreyText)
                        )
                        Text(
                            text = "Cool your heart wai",
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                    else {
                        Image(
                            painterResource(id = R.drawable.favorite),
                            contentDescription = "favourite"
                        )
                    }

                }
                if (item.hasFavoriteIcon) {
                    Row {
                        Image(
                            painterResource(id = R.drawable.favorite),
                            contentDescription = "favourite"
                        )
                    }
                }

            }
        }

    }

}

@Composable
fun BottomMenu(
        fontFamily: FontFamily,
        items: List<BottomMenuContent>,
        modifier: Modifier = Modifier,
        activeHighlightColor: Color = ActiveColor,
        activeTextColor: Color = ActiveText,
        inactiveTextColor: Color = GreyColor,
        initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
                .border(BorderStroke(1.dp, GreyColor))
                .fillMaxWidth()
                .background(
                    WhiteColor
                )
                .padding(15.dp)

    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                fontFamily = fontFamily
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
        fontFamily: FontFamily,
        item: BottomMenuContent,
        isSelected: Boolean = false,
        activeHighlightColor: Color = Color.DarkGray,
        activeTextColor: Color = ActiveText,
        inactiveTextColor: Color = GreyColor,
        onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp),
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(27.dp)
            )
        }
        Text(
            text = item.title,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.2.sp,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
fun FloatyBtn(fontFamily: FontFamily, modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        modifier = modifier
                .height(68.dp)
                .width(200.dp),
        shape = RectangleShape,
        text = {
            Text(
                text = "SEND NEW",
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        },
        icon = {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "image",
                tint = Color.White,
                modifier =
                Modifier
                        .height(41.dp)
                        .width(41.dp)
            )
        },
        onClick = {/* TODO*/ }
    )
}