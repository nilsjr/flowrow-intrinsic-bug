package de.nilsdruyen.flowrow.intrinsic.flowcolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.nilsdruyen.flowrow.intrinsic.Data
import de.nilsdruyen.flowrow.intrinsic.columTestData
import de.nilsdruyen.flowrow.intrinsic.ui.theme.FlowRowIntrinsicBugTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntrinsicColumnBug(model: Data, modifier: Modifier = Modifier) {
    Card(modifier) {
        FlowColumn(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            model.items.forEach { Text(it, Modifier.background(Color.Yellow)) }
        }
    }
}

@Preview
@Composable
private fun WithIntrinsicMaxPreview() {
    FlowRowIntrinsicBugTheme {
        IntrinsicColumnBug(
            model = columTestData,
            modifier = Modifier
                .height(100.dp)
                .width(IntrinsicSize.Max),
        )
    }
}

@Preview
@Composable
private fun WithoutIntrinsicMaxPreview() {
    FlowRowIntrinsicBugTheme {
        IntrinsicColumnBug(
            model = columTestData,
            modifier = Modifier.height(100.dp),
        )
    }
}