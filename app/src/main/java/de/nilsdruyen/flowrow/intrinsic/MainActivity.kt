package de.nilsdruyen.flowrow.intrinsic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.nilsdruyen.flowrow.intrinsic.flowrow.IntrinsicBug
import de.nilsdruyen.flowrow.intrinsic.ui.theme.FlowRowIntrinsicBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowRowIntrinsicBugTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            "Row with IntrinsicSize.Max & items with maxHeight",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Spacer(Modifier.height(4.dp))
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
                                model = testData02,
                                modifier = Modifier
                                    .width(350.dp)
                                    .fillMaxHeight()
                            )
                        }
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Row with IntrinsicSize.Max & items with maxHeight",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Spacer(Modifier.height(4.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            IntrinsicBug(
                                model = testData,
                                modifier = Modifier.width(250.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            IntrinsicBug(
                                model = testData02,
                                modifier = Modifier.width(350.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}