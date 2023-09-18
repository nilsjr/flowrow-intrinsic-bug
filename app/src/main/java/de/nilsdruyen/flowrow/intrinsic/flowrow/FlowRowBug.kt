package de.nilsdruyen.flowrow.intrinsic.flowrow

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.nilsdruyen.flowrow.intrinsic.Data
import de.nilsdruyen.flowrow.intrinsic.testData
import de.nilsdruyen.flowrow.intrinsic.ui.theme.FlowRowIntrinsicBugTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntrinsicBug(model: Data, modifier: Modifier = Modifier) {
    Card(modifier) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            model.items.forEach { Text(it, Modifier.background(Color.Yellow)) }
        }
    }
}

@Preview
@Composable
private fun WithIntrinsicMaxPreview() {
    FlowRowIntrinsicBugTheme {
        IntrinsicBug(
            model = testData,
            modifier = Modifier.height(IntrinsicSize.Max),
        )
    }
}

@Preview
@Composable
private fun WithoutIntrinsicMaxPreview() {
    FlowRowIntrinsicBugTheme {
        IntrinsicBug(
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
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .horizontalScroll(rememberScrollState())
        ) {
            IntrinsicBug(
                model = testData,
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(8.dp))
            IntrinsicBug(
                model = testData,
                modifier = Modifier
                    .width(350.dp)
                    .fillMaxHeight()
            )
        }
    }
}
