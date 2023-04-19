package com.crossfitgym.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crossfitgym.R
import com.crossfitgym.ui.components.ParticleBackground
import com.crossfitgym.ui.components.TopNav
import com.crossfitgym.util.getTimeStamp

@Composable
fun HomePage() {
    val posts = listOf(
        Post(
            id = 0,
            title = "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
            text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            uploader = "John Doe",
            uploadTime = getTimeStamp(),
            imageUrl = "https://unsplash.com/photos/sHfo3WOgGTU",
            comments = emptyList(),
            res = R.drawable.image_3
        ),
        Post(
            id = 0,
            title = "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
            text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            uploader = "John Doe",
            uploadTime = getTimeStamp(),
            imageUrl = "https://unsplash.com/photos/sHfo3WOgGTU",
            comments = emptyList(),
            res = R.drawable.image_2
        ),
        Post(
            id = 0,
            title = "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
            text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            uploader = "John Doe",
            uploadTime = getTimeStamp(),
            imageUrl = "https://unsplash.com/photos/sHfo3WOgGTU",
            comments = emptyList(),
            res = R.drawable.image_1
        )
    )

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopNav()
    }, floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
        }
    }, bottomBar = {
        BottonNav()
    }) { paddingValues ->
        ParticleBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            PostList(posts = posts) { id, comment ->
                val post = posts.find { it.id == id }

            }
        }
    }

}

@Composable
fun PostList(posts: List<Post>, onAddComment: (Int, String) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(posts) { post ->
            Column {
                // Show the uploader name and upload time
                PostItem(post = post)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostItem(post: Post) {
    Card(onClick = { /*TODO*/ }) {
        Image(
            painter = painterResource(id = post.res),
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.titleMedium)
            Text(text = post.text, style = MaterialTheme.typography.bodyMedium)
        }
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Posted on: ${post.uploadTime}", modifier = Modifier
                    .weight(1f),
                style = MaterialTheme.typography.bodySmall
            )
            BadgedBox(
                badge = { Badge { Text(text = "2") } },
                modifier = Modifier.padding(end = 16.dp)
            ) {
//                IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Comment,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
//                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottonNav() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("My Account", Icons.Default.AccountBox),
        NavItem("Notifications", Icons.Default.Notifications),
        NavItem("Settings", Icons.Default.Settings)
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    if (item == items[2]) {
                        BadgedBox(badge = { Badge { Text(text = "4") } }) {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        }
                    } else {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                    }
                },
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: ImageVector
)

data class Post(
    val id: Int,
    val title: String,
    val text: String,
    val uploader: String,
    val uploadTime: String,
    val imageUrl: String,
    val res: Int,
    val comments: List<Comment>
)

data class Comment(
    val id: Int,
    val commenter: String,
    val commentTime: String,
    val text: String
)
