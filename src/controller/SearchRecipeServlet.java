package controller;

import constants.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(Path.SEARCH_RECIPE_PATH)
public class SearchRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //send list from on jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.SEARCH_RECIPE_PAGE_JSP);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<String> newList = list.stream()
                .map(s -> String.valueOf(s))
                .collect(Collectors.toList());

        System.out.println(newList);
        String sql="select name from tbl where id in ("+ StringUtils.join(newList, ",")+")";
        System.out.println(sql);*/
        super.doPost(req, resp);
    }
}
