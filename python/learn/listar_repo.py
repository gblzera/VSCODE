import requests

#token de acesso pessoal
token = "**"

#nome de usuario do github para o qual deseja buscar os repositorios
username = "gblzera"
#username = "daviizn"

#cabeçalhos para autenticação
headers = {
    "Authorization": f"token {token}"
}

#url para buscar os repositorios do github
url = f"https://api.github.com/users/{username}/repos"

#realiza a requesição GET
response = requests.get(url, headers=headers)

#verifica se a requisição foi bem sucedida
if response.status_code == 200:
    repos = response.json() #corverte a resposta JSON em um dicionário py
    print(f"Repositórios de {username} no GitHub:\n")

    # itera sobre os repositorios e imprime o nome e o link
    for repo in repos:
        print(f"- {repo['name']}: {repo['html_url']}")
else:
    print("Erro ao acessar a API:", response.status_code)
