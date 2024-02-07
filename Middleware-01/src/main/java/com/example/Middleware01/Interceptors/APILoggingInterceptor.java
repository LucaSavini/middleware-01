package com.example.Middleware01.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class APILoggingInterceptor implements HandlerInterceptor {

    // Prima della chiamata API
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Request URL :: " + request.getRequestURL().toString() + " :: Start Time = " + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true; // Restituisce true per consentire la chiamata API, false per bloccarla
    }

    // Dopo la chiamata API (posso modificare il modello e altri attributi)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Request URL :: " + request.getRequestURL().toString() + " :: Sent to Handler :: Current Time = " + System.currentTimeMillis());
        // Puoi eseguire operazioni qui dopo la chiamata API
    }

    // Chiamata dopo che ho inviato la risposta API (non posso più modificarla)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        System.out.println("Request URL :: " + request.getRequestURL().toString() + " :: End Time = " + System.currentTimeMillis());
        System.out.println("Request URL :: " + request.getRequestURL().toString() + " :: Time Taken = " + (System.currentTimeMillis() - startTime));
        // Puoi eseguire operazioni qui dopo che la risposta è stata inviata
    }
}
