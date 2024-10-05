# Stock Lookup app

## Overview
This Android application provides users with real-time stock market data. Users can search for specific stocks by entering their symbols and view detailed information such as the company name, current stock price, and percentage change. The data is sourced from global stock markets, ensuring accurate and up-to-date information.

## Key Features
- **Stock Search**: Enter a stock symbol to retrieve live data about the company's stock price, percentage change, and other relevant details.
- **Global Market Data**: The app fetches data from international stock markets, giving users access to a wide range of stock information.
- **Error Handling**: If an invalid stock symbol is entered, or the network request fails, the app provides meaningful error messages to the user.
- **Responsive UI**: The application is designed to work seamlessly on different screen sizes and orientations, providing an optimal user experience across devices.
- **Loading States**: Users are informed with a loading spinner while stock data is being fetched, ensuring they know the app is working in the background.

## Screenshots

### Stock Search:
![Home Screen](screenshots/screenshot1.png)

### Stock Search Result:
![Stock Search Result](screenshots/screenshot2.png)

## Technical Details

### Built With:
- **Android Studio** - The official IDE for Android development.
- **Java** - The programming language used to develop the app.
- **Global Stock Market API** - Provides real-time stock data.

### Requirements:
To set up and run this project, you'll need:
- **Java Development Kit (JDK)** 8 or higher
- **Android Studio** (latest version recommended)
- **Global Stock API Key** (replace `"API_KEY"` with your actual key in the source code)

### Setup Instructions:
1. **Clone the Repository**:
   Clone this repository to your local machine using the following command:
   ```bash
   git clone https://github.com/yourusername/StockMarketApp.git
2. **Open in Android Studio**:

Open Android Studio.
Click on File > Open and select the cloned repository folder.
3. **API Key Configuration**:
Register for an API key from [the stock market API provider].
Add your API key in the MainActivity.java file:
**stockViewModel.fetchStockData(symbol, "YOUR_API_KEY");**

4. **How to Obtain an API Key: Follow these steps to get an API key from Alpha Vantage**:

Go to Alpha Vantage and click on Get Your Free API Key.
Create an account by providing your email and other required details.
After signing up, log in to your account and navigate to the My API Keys section.
Click on Generate API Key to obtain your unique key.
Copy the API key and use it in the app by replacing "YOUR_API_KEY" in the code.

5. **Run the App**:

Click on Run in Android Studio or use Shift + F10 to build and run the app on an emulator or connected device.


**How to Use the App:**
Open the app and enter a stock symbol (e.g., AAPL for Apple, TSLA for Tesla).
Click on the search button to fetch the stock details.
The stock's name, price, and percentage change will be displayed on the screen.
How to Use the App:
Open the app and enter a stock symbol (e.g., AAPL for Apple, TSLA for Tesla).
Click on the search button to fetch the stock details.
The stock's name, price, and percentage change will be displayed on the screen.
