package com.example.superheroes.ui.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.superheroes.R
import com.example.superheroes.dataSource.getPhotoCardList
import com.example.superheroes.model.SuperHero

@Composable
fun ListScreen() {
    ScrollingList()
}

@Composable
fun SuperHeroCard(superHero: SuperHero) {
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp, end = 12.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            SuperHeroImage(superHero)

            Column(
                modifier = Modifier
                    .padding(start = 24.dp)
                    .align(Alignment.CenterVertically)
            ) {
                SuperHeroInfo(superHero)
            }
        }
    }
}

@Composable
fun SuperHeroImage(superHero: SuperHero) {

    Surface(
        modifier = Modifier
            .size(100.dp)
            .border(
                border = BorderStroke(1.dp, color = Color(R.color.purple_500)),
                shape = CircleShape
            ),
        shape = CircleShape,

        ) {

        Image(
            painter = painterResource(id = superHero.image),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun SuperHeroInfo(superHero: SuperHero) {
    Text(text = superHero.name, fontWeight = FontWeight.Bold, color = Color(R.color.purple_500))
    Text(
        text = superHero.date,
        style = MaterialTheme.typography.body2,
        color = Color(R.color.purple_200)
    )
}

@Composable
fun ScrollingList() {

    val itemsList = getPhotoCardList()

    LazyColumn {
        items(itemsList) {
            SuperHeroCard(superHero = it)
        }
    }
}

infix fun NavController.navigateTo(route: String) {
    navigate(route)
}

@Preview
@Composable
fun DefaultPreview() {
    ListScreen()
}