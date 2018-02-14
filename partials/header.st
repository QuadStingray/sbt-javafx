<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MG93HHD" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<header class="md-header" data-md-component="header">
  <nav class="md-header-nav md-grid">
    <div class="md-flex">
      <div class="md-flex__cell md-flex__cell--shrink">
        <a href="$page.home.href$" title="$page.home.title$" class="md-header-nav__button md-logo">
          $ if (page.properties.("material.logo.icon")) $
            <i class="md-icon">$page.properties.("material.logo.icon")$</i>
          $ else $
            <img src="$page.base$$page.properties.("material.logo")$" width="24" height="24">
          $endif$
        </a>
      </div>
      <div class="md-flex__cell md-flex__cell--shrink">
        <label class="md-icon md-icon--menu md-header-nav__button" for="drawer"></label>
      </div>
      <div class="md-flex__cell md-flex__cell--stretch">
        <div class="md-flex__ellipsis md-header-nav__title" data-md-component="title">
          $ if (page.home.active) $
            $page.home.title$
          $ else $
            <span class="md-header-nav__topic">
              $page.home.title$
            </span>
            <span class="md-header-nav__topic">
              $page.title$
            </span>
          $ endif $
        </div>
      </div>
      $ if (page.properties.("material.search")) $
        <div class="md-flex__cell md-flex__cell--shrink">
          <label class="md-icon md-icon--search md-header-nav__button" for="search"></label>
          $search()$
        </div>
      $ else $
        <form name="search" style="display: none">
          <input type="text" name="query">
        </form>
      $ endif $
      $ if (page.properties.("material.repo")) $
        <div class="md-flex__cell md-flex__cell--shrink">
          <div class="md-header-nav__source">
            $source()$
          </div>
        </div>
      $ endif $
    </div>
  </nav>
</header>