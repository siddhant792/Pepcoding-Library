#include <bits/stdc++.h>
using namespace std;
#define ll long long

ll binpow(ll a, ll b, ll md)
{
    ll res = 1;
    while (b != 0)
    {
        if (b & 1)
            res *= a, res %= md;
        a *= a, a %= md;
        b >>= 1;
    }
    return res % md;
}

int main()
{
    return 0;
}