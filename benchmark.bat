@echo off
setlocal enabledelayedexpansion

for /l %%i in (1,1,20) do (
    echo Requesting ID %%i...
    curl http://localhost:8090/products/priceHistory
    echo.
)

pause