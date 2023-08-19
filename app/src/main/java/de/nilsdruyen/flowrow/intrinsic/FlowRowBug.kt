package de.nilsdruyen.flowrow.intrinsic

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.nilsdruyen.flowrow.intrinsic.ui.theme.FlowrowintrinsicbugTheme

data class Data(val text: String, val items: List<String>)

private val testData = Data(
    text = "Hello World",
    items = listOf(
        "Bla bla bla bla bla bla Lorem ipsum dolo ipsum",
        "Hello",
        "Lorem ipsum dolo",
        "Hello",
        "Hello",
        "Lorem ipsum dolo",
    ),
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntrinsicBug(model: Data, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            FlowRow(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                model.items.forEach { Text(it, Modifier.background(Color.Yellow)) }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("Hello")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(model.text)
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.Bottom)
                    .background(Color.Blue)
            )
        }
    }
}

@Preview
@Composable
private fun WithIntrinsicMaxPreview() {
    FlowrowintrinsicbugTheme {
        IntrinsicBug(
            model = testData,
            modifier = Modifier.height(IntrinsicSize.Max),
        )
    }
}

@Preview
@Composable
private fun WithoutIntrinsicMaxPreview() {
    FlowrowintrinsicbugTheme {
        IntrinsicBug(
            model = testData,
            modifier = Modifier,
        )
    }
}

@Preview
@Composable
private fun IntrinsicBugListPreview() {
    FlowrowintrinsicbugTheme {
        Row(
            Modifier
                .horizontalScroll(rememberScrollState())
                .height(IntrinsicSize.Max)
        ) {
            IntrinsicBug(
                model = testData,
                modifier = Modifier
                    .width(250.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IntrinsicBug(
                model = testData,
                modifier = Modifier
                    .width(350.dp)
            )
        }
    }
}
