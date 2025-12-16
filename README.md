# Automated Testing Project

Automated UI tests for web application (Wikipedia.org) and Wikipedia Android mobile application using Selenium WebDriver and Appium.

## Project Structure

```
src/test/
├── java/com/automation/
│   ├── pages/
│   │   ├── web/           # Web Page Objects
│   │   │   ├── BasePage.java
│   │   │   ├── WikipediaHomePage.java
│   │   │   ├── WikipediaSearchResultsPage.java
│   │   │   └── WikipediaArticlePage.java
│   │   └── mobile/        # Mobile Page Objects
│   │       ├── BaseScreen.java
│   │       ├── MainScreen.java
│   │       ├── SearchScreen.java
│   │       └── ArticleScreen.java
│   ├── tests/
│   │   ├── web/           # Web Test Classes
│   │   │   ├── BaseWebTest.java
│   │   │   ├── WikipediaHomePageTest.java
│   │   │   └── WikipediaSearchTest.java
│   │   └── mobile/        # Mobile Test Classes
│   │       ├── BaseMobileTest.java
│   │       ├── WikipediaMainScreenTest.java
│   │       └── WikipediaSearchMobileTest.java
│   └── utils/             # Utilities
│       ├── ConfigReader.java
│       └── WaitUtils.java
└── resources/
    ├── config.properties  # Configuration
    ├── testng.xml         # All tests
    ├── testng-web.xml     # Web tests only
    └── testng-mobile.xml  # Mobile tests only
```

## Requirements

### Environment
- **JDK**: 11 or higher
- **Maven**: 3.6+
- **Browser**: Chrome (latest) or Firefox

### For Mobile Testing
- **Appium Server**: 2.x
- **Android SDK**: with platform-tools
- **Android Emulator** or physical device
- **Wikipedia APK**: installed on device/emulator

## Setup

### 1. Clone the repository
```bash
git clone <repository-url>
cd autotesting-project
```

### 2. Install dependencies
```bash
mvn clean install -DskipTests
```

### 3. Configure settings
Edit `src/test/resources/config.properties`:

```properties
# Web settings
web.base.url=https://www.wikipedia.org
web.browser=chrome
web.headless=false

# Mobile settings
appium.server.url=http://127.0.0.1:4723
android.device.name=emulator-5554
android.platform.version=14
```

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Web Tests Only
```bash
mvn test -Pweb
```

### Run Mobile Tests Only

1. Start Appium server:
```bash
appium
```

2. Start Android emulator or connect device

3. Run tests:
```bash
mvn test -Pmobile
```

### Run Specific Test Class
```bash
mvn test -Dtest=WikipediaHomePageTest
mvn test -Dtest=WikipediaSearchMobileTest
```

## Test Scenarios

### Web Tests (8 scenarios)

| Test Class | Scenario | Description |
|------------|----------|-------------|
| WikipediaHomePageTest | testHomePageLoads | Verify home page loads with logo and search |
| WikipediaHomePageTest | testLanguageLinksPresent | Verify language links are displayed |
| WikipediaHomePageTest | testNavigateToEnglishWikipedia | Navigate to English Wikipedia |
| WikipediaHomePageTest | testNavigateToRussianWikipedia | Navigate to Russian Wikipedia |
| WikipediaSearchTest | testSearchReturnsResults | Verify search returns results |
| WikipediaSearchTest | testSearchNavigatesToArticle | Verify search navigates to article |
| WikipediaSearchTest | testSearchWithDifferentTerms | Parameterized search test |
| WikipediaSearchTest | testArticleContentDisplayed | Verify article content display |

### Mobile Tests (9 scenarios)

| Test Class | Scenario | Description |
|------------|----------|-------------|
| WikipediaMainScreenTest | testMainScreenDisplaysSearchContainer | Verify search container displayed |
| WikipediaMainScreenTest | testExploreTabDisplayed | Verify explore tab visible |
| WikipediaMainScreenTest | testFeedViewDisplayed | Verify feed view displayed |
| WikipediaMainScreenTest | testScrollFeed | Verify feed scrolling |
| WikipediaSearchMobileTest | testSearchReturnsResults | Search returns results |
| WikipediaSearchMobileTest | testOpenArticleFromSearch | Open article from results |
| WikipediaSearchMobileTest | testArticleTitleMatchesSearch | Verify article title |
| WikipediaSearchMobileTest | testSearchWithDifferentKeywords | Parameterized search |
| WikipediaSearchMobileTest | testScrollArticle | Scroll article content |

## Technology Stack

| Component | Technology | Version |
|-----------|------------|---------|
| Language | Java | 11+ |
| Build Tool | Maven | 3.6+ |
| Web Testing | Selenium WebDriver | 4.27.0 |
| Mobile Testing | Appium Java Client | 9.3.0 |
| Test Framework | TestNG | 7.10.2 |
| Driver Management | WebDriverManager | 5.9.2 |

## Mobile Testing Setup Guide

### 1. Install Appium
```bash
npm install -g appium
appium driver install uiautomator2
```

### 2. Create Android Emulator
```bash
# List available system images
sdkmanager --list

# Install system image
sdkmanager "system-images;android-34;google_apis;x86_64"

# Create emulator
avdmanager create avd -n TestDevice -k "system-images;android-34;google_apis;x86_64"

# Start emulator
emulator -avd TestDevice
```

### 3. Install Wikipedia APK
Download from: https://play.google.com/store/apps/details?id=org.wikipedia

Or use APK:
```bash
adb install wikipedia.apk
```

### 4. Verify Setup
```bash
# Check connected devices
adb devices

# Start Appium
appium

# Run mobile tests
mvn test -Pmobile
```

## Reports

Test results are generated in:
- `target/surefire-reports/` - TestNG reports
- Console output with test results

## Troubleshooting

### Web Tests
- **ChromeDriver issues**: WebDriverManager handles driver automatically
- **Timeout errors**: Increase wait times in `config.properties`

### Mobile Tests
- **Appium connection failed**: Ensure Appium server is running on correct port
- **Device not found**: Check `adb devices` output
- **Element not found**: Use Appium Inspector to verify locators

## Author

Portfolio project for automated testing demonstration.

## License

MIT License
