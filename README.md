# Temparary-token form (限時表單專案)
--- 

## 技術使用：
 - Spring Boot
 - PostgreSQL
 - Spring-Data-JPA
 - Swagger

## Docker 產生執行環境相關說明：
 - Dockerfile : 用於進行程式碼進行自動 build code 及建立 image
 - 使用 maven wrapper 進行 maven 相關指令
## VM 參數：
 - AppLogDir: log4j2 的log生成路徑
 - Spring.profiles.active: 指定不同 profile 的 properties