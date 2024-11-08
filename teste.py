#pip install streamlit
#pip install pandas

import streamlit as st
import pandas as pd

st.markdown("### Exemplo de dashboard")

with st.form("form"):
    nome = st.text_input("Nome: ")
    idade = st.text_input("idade")

    botao = st.form_submit_button("ok")
    if botao:
        st.write(nome + " " + idade)