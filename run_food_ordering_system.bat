@echo off
echo Compiling Java files...
javac AdminPackage/*.java
javac CustomerPackage/*.java
javac ReviewPackage/*.java
javac RiderPackage/*.java
javac DashboardPackage/*.java
javac Main/*.java

if errorlevel 1 (
    echo Compilation failed. Please check for errors.
    pause
    exit /b
)

echo Running the FoodDeliverySystem program...
java Main.FoodDeliverySystem

pause
