package com.example.basicscodelab

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme


@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(names) { name ->
                Greeting(name)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val contentDescription =
        if (isExpanded)
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tincidunt ultricies eros, ac auctor nibh sagittis ac. Etiam in neque ligula. Suspendisse pretium molestie neque. Donec quis nisl dolor. Donec vulputate maximus dolor sed ullamcorper. In sit amet velit sed elit dictum vestibulum. Nullam mollis urna eget tristique aliquam. In id dolor magna. Ut fermentum a justo at elementum."
        else
            ""

    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Hello,")
                        Text(
                            text = name,
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                    }
                    IconButton(onClick = { isExpanded = !isExpanded }) {
                        Icon(
                            imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                            contentDescription = if(isExpanded) "Show less" else "Show more"
                        )
                    }
                }
                if (isExpanded) {
                    Text(text = contentDescription)
                }
            }
        }
    }


}

@Preview(name = "Light Mode", widthDp = 320, showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 320,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    BasicsCodelabTheme {
        Greeting(name = "World")
    }
}

@Preview(name = "Light Mode", widthDp = 320, showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 320,
    showBackground = true
)
@Composable
fun GreetingsPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}