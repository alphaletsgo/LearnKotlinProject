package cn.isif.kotlin.demo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

/**
 * 使用Retrofit获取kotlin的repo 并生成一个html文件显示一些信息
 */

interface GetHub{
    @GET("/repos/{owner}/{repo}")
    fun getRepo(@Path("owner") owner:String,@Path("repo") repo:String):Call<Repository>
}

fun main() {
    var rqGithub = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GetHub::class.java)

    var response = rqGithub.getRepo("JetBrains","Kotlin").execute()

    var repository = response.body()

    if (repository==null){
        println("Error!!Code:${response.code()} - Message:${response.message()}")
    }else{
        //打印
        println(repository.name)
        println(repository.owner.login)
        println(repository.stargazers_count)
        println(repository.forks_count)
        println(repository.html_url)

        //生成html文件
        File("Korlin.html").writeText("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>${repository.owner.login} - ${repository.name}</title>
            </head>
            <body>
                <h1><a href='${repository.html_url}'>${repository.owner.login} - ${repository.name}</a></h1>
                <p>${repository.description}</p>
                <p>Stars:${repository.stargazers_count}</p>
                <p>Forks:${repository.forks_count}</p>
            </body>
            </html>
        """.trimIndent())
    }
}