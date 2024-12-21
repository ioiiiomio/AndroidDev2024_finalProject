# AndroidDev2024_finalProject
![Logo_bg](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/main/READMEimg/logo_bg.png)

It is Koshkimbayeva Zhaniya's &amp; Zhaidary Arukhanym's Android 2024 Fall course project

# Project Description
Our project is called "Fashionista". It is an online shopping app with connected API, registration, favorites and checkout. 

# Final Description: 
- Coroutines in ProfileFragment:
  - **logIn.setOnClickListener:** When the login button is clicked, a coroutine is launched using lifecycleScope.launch.
This runs the handleRegistrationOrLogin function
  - **handleRegistrationOrLogin**: withContext(Dispatchers.Main) is used to switch to the Main thread for UI-related operations like showing toast messages or updating the UI
  - **isUsernameTaken and fetchUsers methods**
![Coroutines](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/main/READMEimg/coroutine.png)

- Room for CartFragment

New API:
**For User handling:**
- https://6765aea9410f84999655dfac.mockapi.io/users
**Custom API for items**:
- https://my-json-server.typicode.com/karukaaa/fashionistaApi/items

## References
We referenced app such as: GoldApple, ZARA, Lichi

**Canva board link:** https://www.canva.com/design/DAGYUnoLAHc/mcc1txq_x2ovOfjgioPyrg/edit?utm_content=DAGYUnoLAHc&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton
![References](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/main/READMEimg/ref_new.png)


# Lab_3 description:
## Main activities: MainActivity.kt
## Fragments: 
- Catalog
- Favorite Items (Not Finished yet)
- Home Page
- Profile (Not Finished yet)
- Shopping Cart (Not Finished yet)

**(UPDATED)**
## API endpoints: https://fakestoreapi.com/category/
    -> /Jeweleries
    -> /Men's Clothes
    -> /Women's Clothes
![API Endpoints](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/main/READMEimg/API.png)
    

## Plans for future updates:
- Add feature of "Favourites"(DONE)
- Add feature of "Cart"(DONE)
- feature of "Checkout"(NOT DONE)
- feature of "Registration"(DONE)
- feature of "Filtering" items(NOT DONE)
- AI (Maybe)

![App showcase](https://github.com/ioiiiomio/AndroidDev2024_finalProject/blob/main/READMEimg/app.png)


