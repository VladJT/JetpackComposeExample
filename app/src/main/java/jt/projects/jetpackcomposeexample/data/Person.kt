package jt.projects.jetpackcomposeexample.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jt.projects.jetpackcomposeexample.R

data class Person(
    val imageId: Int,
    val name: String,
    val description: String = ""
)

fun getPersonTestData(): List<Person> =
    listOf(
        Person(
            R.drawable.man,
            "Ivan",
            "DevOps на уровне пользователя (CI/CD, мониторинг, прикладная инфраструктура).\n" +
                    "Java 8. Kotlin. Kotlin Compiler. Экспертное знание Java 8. Продвинутое знание Kotlin. Maven, gradle, sbt. Экспертное знание SQL.\n"
        ),
        Person(
            android.R.drawable.star_big_on, "Stat", "Разработка и настройка ЦФТ-Банк (IBSO).\n" +
                    "Минимальный опыт работы по разработке в среде ЦФТ, желательно знание PL PLUS. Понимание банковских процессов."
        ),
        Person(
            R.drawable.ic_launcher_foreground,
            "Vlad",
            "На проекте ты познакомишься с архитектурными особенностями операционной системы Android; узнаешь различные механизмы сохранения данных, разберешь типичные ошибки и стандартные"
        ),
        Person(
            android.R.drawable.ic_popup_disk_full,
            "Semen",
            "Разработчик мобильных приложений Android (Стажер)\n" +
                    "з/п не указана\n" +
                    "Центр финансовых технологий, Новосибирск"
        ),
        Person(
            R.drawable.man,
            "SEMEN",
            "DevOps на уровне пользователя (CI/CD, мониторинг, прикладная инфраструктура).\n" +
                    "Java 8. Kotlin. Kotlin Compiler. Экспертное знание Java 8. Продвинутое знание Kotlin. Maven, gradle, sbt. Экспертное знание SQL.\n"
        )
    )

@Composable
fun PersonItemRow(person: Person) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(Color.White)
    )
    {
        Image(
            painter = painterResource(id = person.imageId),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(3.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
            Text(person.name, fontSize = 16.sp)
            Text(person.description, fontSize = 16.sp, fontStyle = FontStyle.Italic)
        }
    }
}