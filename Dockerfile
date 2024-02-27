# Exercise JDBC
Repo:
git@github.com:HANICA-DEA/exercise-jdbc.git

# Source: https://learn.microsoft.com/en-us/sql/linux/quickstart-install-connect-docker?view=sql-server-ver16&tabs=cli&pivots=cs1-bash
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=AJO1FEhsBxWL' -p 1433:1433 --name sqlserver --platform linux/amd64 -d mcr.microsoft.com/mssql/server:2019-latest


