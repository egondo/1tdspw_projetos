import streamlit as st
import pandas as pd

st.set_page_config(layout="wide")
st.markdown("### DASHBOARD")

arq = st.file_uploader("arquivo csv")

if arq:
    df = pd.read_csv(arq, sep=";")
    df['total'] = df['quantidade'] * df['valor']
    df['mes'] = df['data'].apply(lambda x: int(x.split("/")[1]))
    
    df_agrupado = pd.pivot_table(df, index="mes", columns="loja", aggfunc="sum", values="total")
    
    col1, col2, col3 = st.columns(3)
    with col1:
        st.dataframe(df_agrupado)

    with col2:
        st.bar_chart(df_agrupado)

    with col3:
        st.bar_chart(df_agrupado, stack=False)
