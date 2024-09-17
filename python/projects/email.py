import smtplib
import email.message

def enviar_email():
    corpo_email = """
    TESTE DE EMAIL
    """

    msg = email.message.Message()
    msg['Subject'] = 'Teste de envio de email'
    msg['From'] = f'gabriel@2jbpo.com.br'
    msg['To'] = 'gabriel.kpaz@gmail.com'
    password = 'Ser41173525'
    msg.add_header('Content-Type','text/html')
    msg.set_payload(corpo_email)

    s = smtplib.SMTP('smtp.gmail.com; 587')
    s.starttls()
    s.login(msg['From'], password)
    s.sendmail(msg['From'], [msg['Subject']], msg.as_string().encode('utf-8'))
    print('Email enviado')

enviar_email()