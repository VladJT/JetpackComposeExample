package jt.projects.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import jt.projects.jetpackcomposeexample.screens.MainCard
import jt.projects.jetpackcomposeexample.screens.TabLayout


class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.6f),
                contentScale = ContentScale.Crop
            )
            Column() {
                MainCard()
                TabLayout()
            }

        }
    }

}
