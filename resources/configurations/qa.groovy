// dev.groovy
def config = [
        MONGODB_URI: 'mongodb://qa_mongo_username:qa_mongo_pwd@host.docker.internal:27019/?authSource=admin\\&tls=false',
        APP_ENV: 'qa',
        DEV_NGINX_PORT:'82'
]
return config
