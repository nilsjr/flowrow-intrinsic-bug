package de.nilsdruyen.flowrow.intrinsic.flowrow

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
import de.nilsdruyen.flowrow.intrinsic.Data
import de.nilsdruyen.flowrow.intrinsic.testData
import de.nilsdruyen.flowrow.intrinsic.ui.theme.FlowRowIntrinsicBugTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntrinsicComplexBug(model: Data, modifier: Modifier = Modifier) {
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
//                .weight(1f) // TODO explain example in list with weight
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp)
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
    FlowRowIntrinsicBugTheme {
        IntrinsicComplexBug(
            model = testData,
            modifier = Modifier.height(IntrinsicSize.Max),
        )
    }
}

@Preview
@Composable
private fun WithoutIntrinsicMaxPreview() {
    FlowRowIntrinsicBugTheme {
        IntrinsicComplexBug(
            model = testData,
            modifier = Modifier,
        )
    }
}

@Preview(group = "complex")
@Composable
private fun IntrinsicBugListPreview() {
    FlowRowIntrinsicBugTheme {
        Row(
            Modifier
                .horizontalScroll(rememberScrollState())
                .height(IntrinsicSize.Max)
        ) {
            IntrinsicComplexBug(
                model = testData,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IntrinsicComplexBug(
                model = testData,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(350.dp)
            )
        }
    }
}
