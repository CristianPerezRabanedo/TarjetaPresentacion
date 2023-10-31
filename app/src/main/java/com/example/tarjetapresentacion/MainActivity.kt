package com.example.tarjetapresentacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TarjetaPresentacion()
                }
            }
        }
    }
}

@Composable
fun TarjetaPresentacion() {
    val image = painterResource(R.drawable.fondo3)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
           // alpha = 0.5f
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "IES Virgen De La Paloma",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            TarjetaPresentacionTop(modifier = Modifier.weight(3F))
            TarjetaPresentacionBottom(modifier = Modifier.weight(2F))
        }
    }
}

@Composable
fun TarjetaPresentacionTop(modifier: Modifier) {
    val image = painterResource(id = R.drawable.dibujo)
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)

        )
        Text(
            text = "Cristian Pérez Rabanedo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(0.dp, 24.dp, 0.dp, 8.dp)

        )
        Text(
            text = "Técnico Informático",
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

            )
    }
}

@Composable
fun TarjetaPresentacionBottom(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        IconosProgramas()
        TarjetaPresentacionRow("Cristian Pérez Rabanedo",R.drawable.iconolinkedin,"https://www.linkedin.com/in/cristian-pérez-rabanedo/")
        TarjetaPresentacionRow("+34 666 222 444", R.drawable.iconowhatsapp)
        TarjetaPresentacionRow("cristian.perez.rabanedo@gmail.com",R.drawable.iconogmail)
    }
}

@Composable
fun TarjetaPresentacionRow(contact: String, imageResId: Int, linkedinUrl: String?=null) {
    val image = painterResource(id = imageResId)
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 2.dp, 20.dp, 2.dp),

    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .padding(5.dp)
                .wrapContentWidth(Alignment.Start)
        )

            val onClick: () -> Unit = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
                context.startActivity(intent)

        }
        Text(
            contact,
            modifier = Modifier
                .padding(10.dp, 0.dp, 10.dp, 0.dp)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .clickable { if(linkedinUrl != null) onClick()},
            color = Color.White,
            fontWeight = FontWeight.Bold

            )
    }
}

@Composable
fun IconosProgramas() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 16.dp, 0.dp, 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.html),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.kotlin),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.java),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.php),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaPresentacionPreview() {
    TarjetaPresentacionTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            TarjetaPresentacion()
        }
    }
}
