# AndroidDev2024_finalProject
[img](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/Zhaniya/READMEimg/logo.png)

It is Koshkimbayeva Zhaniya's &amp; Zhaidary Arukhanym's Android 2024 Fall course project

# Project Description
Our project is called "Fashionista". It is an online shopping app with connected API, registration, favorites and checkout. 

# Lab_3 description:
## Main activities: MainActivity.kt
## Fragments: 
- Catalog
- Favorite Items (Not Finished yet)
- Home Page
- Profile (Not Finished yet)
- Shopping Cart (Not Finished yet)
  
## API endpoints: https://fakestoreapi.com/category/
    -> /Jeweleries
    -> /Men's Clothes
    -> /Women's Clothes
[    img](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/Zhaniya/READMEimg/API.png)
    

## Plans for future updates:
- Add feature of "Favourites"
- Add feature of "Cart"
- feature of "Checkout"
- feature of "Registration"
- feature of "Filtering" items
- AI (Maybe)

## References
We referenced app such as: GoldApple, ZARA, Lichi

[img](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/Zhaniya/READMEimg/References.png)

## Updates log: 

### 
Yet to be updated

### 13 Dec 2024
1) Created Fragments, Activities, Adapters directories
2) Renamed MainPageFragment.kt -> HomePage.kt
3) Added Catalogue, FavoriteItems, Profile, ShoppingCart Fragments
4) Put  Catalogue, FavoriteItems, Profile, ShoppingCart, HomePage Fragments to Fragments directory
5) Added fragment_catalog, fragment_favorite_items, fragment_main_page, fragment_profile, fragment_shopping_cart.xml files to "Layout" directory
6) Created Menu, Navigation directories in Res
7) Created nav_graph.xml file. It is part of the Navigation Component in Android, which is a framework that simplifies in-app navigation by managing the transitions between destinations.
8) Added bottom_nav_menu.xml in Menu to Navigation to to define the individual items displayed in the bottom navigation bar. Each item in the menu corresponds to a fragment or screen in the app
9) Updated MainActivity.kt: Added NavController atributes
10) Updated activity_main.xml: added BottomNavigationView for navigation bar
