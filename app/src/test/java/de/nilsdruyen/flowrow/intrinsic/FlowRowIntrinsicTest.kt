package de.nilsdruyen.flowrow.intrinsic

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.getUnclippedBoundsInRoot
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.height
import de.nilsdruyen.flowrow.intrinsic.flowrow.IntrinsicBug
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class FlowRowIntrinsicTest {

    @get:Rule
    val rule = createComposeRule()

    private fun heightOf(tag: String) = rule.onNodeWithTag(tag).getUnclippedBoundsInRoot().height

    @Test
    fun `IntrinsicSize Max height matches wrap content height`() {
        rule.setContent {
            Column {
                IntrinsicBug(testData, Modifier.width(250.dp).testTag("wrap"))
                IntrinsicBug(testData, Modifier.width(250.dp).height(IntrinsicSize.Max).testTag("intrinsic"))
            }
        }
        assertEquals(heightOf("wrap"), heightOf("intrinsic"))
    }

    @Test
    fun `Row with IntrinsicSize Max is as tall as its tallest card`() {
        rule.setContent {
            Column {
                IntrinsicBug(testData, Modifier.width(250.dp).testTag("wrap"))
                Row(Modifier.height(IntrinsicSize.Max).horizontalScroll(rememberScrollState())) {
                    IntrinsicBug(testData, Modifier.width(250.dp).fillMaxHeight().testTag("inRow"))
                    IntrinsicBug(testData02, Modifier.width(350.dp).fillMaxHeight())
                }
            }
        }
        assertEquals(heightOf("wrap"), heightOf("inRow"))
    }
}
