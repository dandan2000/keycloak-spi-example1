<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=true; section>
    <#if section = "header">
        Control de Acceso Extra
    <#elseif section = "form">
        <form action="${url.loginAction}" method="post">
            <div class="form-group">
                <label for="secret_word">Ingresa la palabra mágica:</label>
                <input type="password" id="secret_word" name="secret_word" class="form-control" autofocus/>
            </div>
            <input class="btn btn-primary" type="submit" value="Verificar"/>
        </form>
    </#if>
</@layout.registrationLayout>