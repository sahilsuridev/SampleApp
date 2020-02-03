This repository contains a detailed sample app in Kotlin that implements MVVM architecture 
using Dagger2, Room, Glide and Android Jetpack Components.

The app has following packages:

    data: It contains all the data accessing and manipulating components.
    di: Dependency providing classes using Dagger2.
    ui: View classes along with their corresponding ViewModel.
    binding: data binding adapters.

The App UI is updated with the help of DataBaseBinding Library which reacts with values from ViewModel.	
This works on the principle of Single Source of truth and has offline storage.
But for Demo purpose, we are fetching the data from server every time.
