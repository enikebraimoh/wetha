package ng.adashi.network

import com.enike.wetha.utils.Constants.API_KEY
import com.enike.wetha.utils.Constants.HOST
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class TokenInterceptor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.header("x-rapidapi-key") == null) {
            if (!API_KEY.isEmpty()) {
                request = request.newBuilder()
                    .addHeader("x-rapidapi-host", "$HOST")
                    .addHeader("x-rapidapi-key", "$API_KEY")
                    .build()
            }
        }
        return chain.proceed(request)
    }

}