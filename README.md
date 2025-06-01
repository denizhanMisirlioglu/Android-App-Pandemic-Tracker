# Pandemic-Tracker

<p align="center">
  <img src="docs/highres_output.gif" width="100%" alt="Pandemic-Tracker Demo GIF">
</p>


**Pandemic-Tracker** is my very first Android project (April 2022). It’s an app designed to track and compare intercontinental COVID-19 statistics in real time.

---

## Project Overview

- **Platform:** Android
- **Language:** Kotlin
- **UI:** XML Layouts

I built this app to learn Android development fundamentals—connecting a live data source to a mobile interface and visualizing up-to-date pandemic metrics.

---

## Data Pipeline

1. **Data Extraction (Python Script)**  
   - A Python script runs periodically to scrape the latest COVID-19 dataset from Our World in Data.  
   - The script parses CSV files, converts them into JSON format, and uploads the results to a Firebase Realtime Database.

2. **Backend:**  
   - **Firebase Realtime Database** stores JSON objects representing country- and continent-level COVID metrics (e.g., new cases, total cases, deaths, vaccination rates).  
   - Data is organized by continent keys, making it easy to fetch and display region-specific statistics.

---

## App Architecture

- **Firebase Integration**  
  - Retrieves JSON data directly from the Firebase Realtime Database.  
  - Uses Kotlin’s coroutines and listeners to observe data changes and update the UI automatically.

- **UI Components & Design**  
  - **RecyclerView** with custom adapters to list continents and their statistics.  
  - **CardView** elements that display key figures at a glance (e.g., total cases, new cases, total deaths).  
  - **ProgressBar** indicators while data is loading.  
  - **Swipe-to-Refresh** to allow users to manually refresh the latest numbers.

- **Navigation & Interactivity**  
  - **onClick Listeners**: Tapping a continent card opens a detailed view showing country-by-country comparisons.  
  - **Intents**: Pass JSON payloads between activities to maintain data consistency.  
  - **Image Buttons**: Quick-access icons for toggling between total and new-case views.

- **Data Visualization**  
  - **Table Layouts** to organize per-country statistics.  
  - **Graphs** (implemented via a charting library) to show trends over time within each continent.  
  - **Sorting Algorithms** let users reorder countries by metrics such as “highest new cases,” “lowest death rate,” or “highest vaccination coverage.”

- **User Feedback**  
  - **Toast Messages** confirm data fetch success, refresh actions, or any network errors.  
  - **Snackbars** for brief status updates (e.g., “Data is up to date,” “Server unreachable—showing cached data”).

---

## Key Features

- 🔒 **Real-Time Updates**  
  Always shows the most recent COVID-19 figures, thanks to our live Python-to-Firebase data pipeline.

- 🌍 **Intercontinental Comparison**  
  Quickly compare COVID-19 statistics across continents and drill down to individual countries.

- 📊 **Interactive Charts & Tables**  
  Visualize trends over time and sort data to find patterns (e.g., which region is recovering fastest).

- 📱 **Modern UI/UX**  
  Responsive RecyclerViews, card-based design, and intuitive navigation make it easy for users to find the information they need.

- 🔄 **Pull-to-Refresh**  
  Users can swipe down to trigger a manual refresh, ensuring they always see up-to-date numbers.

---


